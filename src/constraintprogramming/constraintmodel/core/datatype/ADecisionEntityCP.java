package constraintprogramming.constraintmodel.core.datatype;

import constraintprogramming.constraintmodel.core.domain.ADomain;

public class ADecisionEntityCP<T> extends AValueEntityCP<T>
    implements IDecisionEntityCP<T> {
    protected ADomain<T> domain_;

    @Override
    public boolean inDomain(T value) {
        return domain_.contains(value);
    }
}
