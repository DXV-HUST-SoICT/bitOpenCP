package constraintprogramming.searchengine.variableselector;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.constraintmodel.variable.IntVarCP;
import constraintprogramming.searchengine.taskstack.BranchQueue;
import constraintprogramming.searchengine.taskstack.TaskStack;

import java.util.HashSet;

public class LargeDomainFirst implements IVariableSelector {
    @Override
    public int select(ICPModel cm, TaskStack taskStack) {
        HashSet<IVarCP> variables = cm.getVariables();
        IVarCP var = new IntVarCP();
        for (IVarCP v : variables) {
            if ((var == null) || v.getDomainElements().size() > var.getDomainElements().size()) {
                var = v;
            }
        }
        if (var.getDomain().size() == 1) {
            return 0;
        }
        BranchQueue bq = new BranchQueue();
        taskStack.taskStack.push(bq);
        bq.oldDomain.put(var, var.getDomain());
        return 1;
    }
}
