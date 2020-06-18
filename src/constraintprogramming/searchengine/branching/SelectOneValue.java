package constraintprogramming.searchengine.branching;

import constraintprogramming.constraintmodel.core.domain.Domain;
import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.constraintmodel.variable.IntVarCP;
import constraintprogramming.searchengine.taskstack.Branch;
import constraintprogramming.searchengine.taskstack.TaskStack;

import java.util.ArrayList;

public class SelectOneValue<T> implements IBranching<T> {

    @Override
    public void branch(ICPModel cm, TaskStack taskStack) {
        assert taskStack.taskStack.peek().oldDomain.size() == 1;
        assert taskStack.taskStack.peek().branchQueue.size() == 0;
        IVarCP var = new IntVarCP();
        IDomain domain = new Domain();
        for (IVarCP v : taskStack.taskStack.peek().oldDomain.keySet()) {
            var = v;
            domain = taskStack.taskStack.peek().oldDomain.get(v);
        }
        ArrayList<T> de = new ArrayList<>();
        de.addAll(domain.getDomainElements());
        for (int i = 0; i < de.size(); i++) {
            Branch nb = new Branch();
            Domain<T> nd = new Domain<>();
            nd.add(de.get(i));
            nb.newDomain.put(var, nd);
        }
    }
}
