package constraintprogramming.constraintmodel.core.datatype;

import constraintprogramming.constraintmodel.core.domain.IDomain;

import java.util.Collection;

public class ADecisionEntityCP<T> extends AValueEntityCP<T>
    implements IDecisionEntityCP<T> {
    protected IDomain<T> domain_;

    @Override
    public boolean inDomain(T value) {
        return domain_.contains(value);
    }

    @Override
    public Collection<T> getDomain() {
        return domain_.domain();
    }
}
