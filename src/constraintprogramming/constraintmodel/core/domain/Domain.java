package constraintprogramming.constraintmodel.core.domain;

import java.util.Collection;
import java.util.HashSet;

public class Domain<T> extends ADomain<T> implements IDomain<T> {

    private HashSet<T> domain_ = new HashSet<>();

    public Domain(Collection<T> collection) {
        domain_.addAll(collection);
    }

    public Domain() {
    }

    @Override
    public boolean contains(T value) {
        return domain_.contains(value);
    }

    @Override
    public int size() {
        return domain_.size();
    }

    @Override
    public Collection<T> getDomainElements() {
        return domain_;
    }

    @Override
    public T nextValue(T value) {
        return null;
    }

    @Override
    public T prevValue(T value) {
        return null;
    }

    @Override
    public void add(T value) {
        domain_.add(value);
    }

    @Override
    public void add(IDomain<T> domain) {
        domain_.addAll(domain.getDomainElements());
    }

    @Override
    public void remove(T value) {
        domain_.remove(value);
    }

    @Override
    public void remove(IDomain<T> domain) {
        domain_.removeAll(domain.getDomainElements());
    }
}
