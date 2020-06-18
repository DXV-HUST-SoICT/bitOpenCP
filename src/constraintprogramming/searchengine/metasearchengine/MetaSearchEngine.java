package constraintprogramming.searchengine.metasearchengine;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.searchengine.CSPSearchEngine;
import constraintprogramming.searchengine.searchengine.ISearchEngine;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.searchengine.taskstack.Branch;
import constraintprogramming.searchengine.taskstack.BranchQueue;
import constraintprogramming.searchengine.taskstack.TaskStack;

import java.util.ArrayList;

public class MetaSearchEngine extends AMetaSearchEngine implements IMetaSearchEngine {

    IPropagationEngineCP pe;
    ICPModel cm;
    TaskStack taskStack = new TaskStack();
    ArrayList<ISearchEngine> se;
    ArrayList<Solution> solution = new ArrayList<>();

    public MetaSearchEngine() {
        se = new ArrayList<>();
    }

    @Override
    public void setPropagationEngine(IPropagationEngineCP pe) {
        this.pe = pe;
    }

    @Override
    public void setConstraintModel(ICPModel cm) {
        this.cm = cm;
    }

    @Override
    public void run() {
        Branch branch = new Branch();
        BranchQueue bq = new BranchQueue();
        for (IVarCP var : cm.getVariables()) {
            branch.newDomain.put(var, var.getDomain());
            bq.oldDomain.put(var, var.getDomain());
        }
        bq.branchQueue.add(branch);
        taskStack.taskStack.push(bq);
        se.add(new CSPSearchEngine(pe, cm, taskStack));
        for (int i = 0; i < se.size(); i++) {
            solution = se.get(i).search(solution);
        }
    }

    @Override
    public ArrayList<Solution> getSolution() {
        return solution;
    }
}
