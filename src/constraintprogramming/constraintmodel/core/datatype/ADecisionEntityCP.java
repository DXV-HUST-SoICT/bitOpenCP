package constraintprogramming.constraintmodel.core.datatype;

import constraintprogramming.constraintmodel.core.domain.IDomain;

import java.util.Collection;

/***
 * Model's factors can change value
 * @param <T>
 */
public abstract class ADecisionEntityCP<T> extends AValueEntityCP<T>
    implements IDecisionEntityCP<T> {
    /***
     * Domain of value (i.e. all of values that entity can be assigned)
     */
    protected IDomain<T> domain_;

    @Override
    public boolean inDomain(T value) {
        return domain_.contains(value);
    }

    @Override
    public Collection<T> getDomain() {
        return domain_.getDomain();
    }
}
