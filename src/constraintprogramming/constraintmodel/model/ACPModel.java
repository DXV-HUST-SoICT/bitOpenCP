package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;

public abstract class ACPModel implements ICPModel {
    protected EModelState state_ = EModelState.OPEN;
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
