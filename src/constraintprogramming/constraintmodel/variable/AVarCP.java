package constraintprogramming.constraintmodel.variable;

import constraintprogramming.constraintmodel.core.datatype.ADecisionEntityCP;

import java.util.ArrayList;

public abstract class AVarCP<T> extends ADecisionEntityCP<T>
        implements IVarCP<T> {
    @Override
    public boolean isAssigned() {
        return getDomain().size() == 1;
    }

    @Override
    public T getValue() {
        ArrayList<T> d = new ArrayList<>();
        d.addAll(this.getDomainElements());
        return d.get(0);
    }
}
