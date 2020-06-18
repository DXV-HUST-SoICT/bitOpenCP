package constraintprogramming.searchengine.branchselector;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.searchengine.taskstack.Branch;
import constraintprogramming.searchengine.taskstack.TaskStack;

public interface IBranchSelector {
    public Branch selectBranch(ICPModel cm, TaskStack taskStack);
}
