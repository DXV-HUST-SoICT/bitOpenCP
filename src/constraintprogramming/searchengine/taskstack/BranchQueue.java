package constraintprogramming.searchengine.taskstack;

import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.constraintmodel.variable.IVarCP;

import java.util.ArrayList;
import java.util.HashMap;

public class BranchQueue {
    /**
     * oldDomain store domain value of selected variables before branching
     */
    public HashMap<IVarCP, IDomain> oldDomain = new HashMap<>();
    public ArrayList<Branch> branchQueue = new ArrayList<>();
}
