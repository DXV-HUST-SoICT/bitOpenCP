package constraintprogramming.searchengine.branchselector;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.searchengine.taskstack.Branch;
import constraintprogramming.searchengine.taskstack.TaskStack;

public class SelectFirstBranch implements IBranchSelector {
    @Override
    public Branch selectBranch(ICPModel cm, TaskStack taskStack) {
        if (taskStack.taskStack.peek().branchQueue.size() == 0) {
            return null;
        }
        Branch res = taskStack.taskStack.peek().branchQueue.get(0);
        taskStack.taskStack.peek().branchQueue.remove(0);
        return res;
    }
}
