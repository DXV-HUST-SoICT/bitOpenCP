package constraintprogramming.searchengine.branching;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.searchengine.taskstack.TaskStack;

public interface IBranching<T> {
    public void branch(ICPModel cm, TaskStack taskStack);
}
