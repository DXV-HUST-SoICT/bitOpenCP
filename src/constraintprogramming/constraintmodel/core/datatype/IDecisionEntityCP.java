package constraintprogramming.constraintmodel.core.datatype;

import java.util.Collection;

public interface IDecisionEntityCP<T> extends IValueEntityCP<T> {
    public boolean inDomain(T value);
    public Collection<T> getDomain();
}
