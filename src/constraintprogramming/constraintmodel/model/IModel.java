package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;

public interface IModel {
    public void open();
    public void close();
    public void addConstraint();
    public EModelState getState();
}
