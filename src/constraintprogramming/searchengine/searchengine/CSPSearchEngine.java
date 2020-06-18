package constraintprogramming.searchengine.searchengine;

import constraintprogramming.constraintmodel.core.datatype.ESatisfaction;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.boundestimator.CSPEstimator;
import constraintprogramming.searchengine.boundestimator.IBoundEstimator;
import constraintprogramming.searchengine.branching.IBranching;
import constraintprogramming.searchengine.branching.SelectOneValue;
import constraintprogramming.searchengine.branchselector.IBranchSelector;
import constraintprogramming.searchengine.branchselector.SelectFirstBranch;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.searchengine.taskstack.Branch;
import constraintprogramming.searchengine.taskstack.TaskStack;
import constraintprogramming.searchengine.variableselector.IVariableSelector;
import constraintprogramming.searchengine.variableselector.LargeDomainFirst;

import java.util.ArrayList;

public class CSPSearchEngine extends ASearchEngine implements ISearchEngine {

    private IVariableSelector variableSelector = new LargeDomainFirst();
    private IBranching branching = new SelectOneValue();
    private IBoundEstimator boundEstimator = new CSPEstimator();
    private IBranchSelector branchSelector = new SelectFirstBranch();

    private IPropagationEngineCP pe;
    private ICPModel cm;
    private TaskStack taskStack;

    public CSPSearchEngine(IPropagationEngineCP pe, ICPModel cm, TaskStack taskStack) {
        this.pe = pe;
        this.cm = cm;
        this.taskStack = taskStack;
    }

    @Override
    public ArrayList<Solution> search(ArrayList<Solution> curSolution) {
        if (curSolution.size() > 0) {
            return curSolution;
        }
        ArrayList<Solution> solution = new ArrayList<>();
        while ((taskStack.taskStack.size() > 0) && (solution.size() == 0)) {
            while (true) {
                Branch branch = branchSelector.selectBranch(cm, taskStack);
                if (branch == null) {
//                    pe.revertPruning();
                    for (IVarCP var : taskStack.taskStack.peek().oldDomain.keySet()) {
                        var.setDomain(taskStack.taskStack.peek().oldDomain.get(var));
                    }
                    taskStack.taskStack.pop();
                    break;
                }
                for (IVarCP var : branch.newDomain.keySet()) {
                    var.setDomain(branch.newDomain.get(var));
                }
                pe.propagatePruning();

                boolean isAllAssigned = true;
                for (IVarCP var : cm.getVariables()) {
                    if (var.getDomain().size() == 0) {
                        pe.revertPruning();
                        continue;
                    }
                    if (var.getDomain().size() != 1) {
                        isAllAssigned = false;
                    }
                }

                if (isAllAssigned) {
//                    System.out.println("Checkpoint");
//                    for (IVarCP var : cm.getVariables()) {
//                        System.out.println(var + " = " + var.getValue());
//                    }
                    boolean satisfied = true;
                    for (IConstraintCP cons : cm.getConstraints()) {
                        if ((!cons.isAssigned()) || (cons.getValue() != ESatisfaction.TRUE)) {
                            satisfied = false;
                            break;
                        }
                    }
                    if (satisfied) {
                        Solution sol = new Solution();
                        for (IVarCP var : cm.getVariables()) {
                            sol.assign(var, var.getValue());
                        }
                        solution.add(sol);
                        pe.revertPruning();
                        break;
                    }
                    pe.revertPruning();
                } else {
                    variableSelector.select(cm, taskStack);
                    branching.branch(cm, taskStack);
                    break;
                }
            }
        }
        return solution;
    }
}
