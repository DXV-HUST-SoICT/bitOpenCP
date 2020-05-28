package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;

public abstract class AModel implements IModel {
    protected EModelState state_;
    @Override
    public void open() {
        state_ = EModelState.OPEN;
    }

    @Override
    public void close() {
        state_ = EModelState.CLOSE;
    }

    @Override
    public EModelState getState() {
        return this.state_;
    }
}
