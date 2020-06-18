package constraintprogramming.searchengine.variableselector;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.searchengine.taskstack.TaskStack;

public interface IVariableSelector {
    public int select(ICPModel cm, TaskStack taskStack);
}
