package constraintprogramming.constraintmodel.core.domain;

import java.util.Collection;

public interface IDomain<T> {
    public boolean contains(T value);
    public int size();
    public Collection<T> domain();
    public T nextValue(T value);
    public T prevValue(T value);
}
