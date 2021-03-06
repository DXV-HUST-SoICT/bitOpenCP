package constraintprogramming.constraintmodel.core.domain;

import utils.algorithms.BinarySearch;

import java.util.*;

public class IntDomain extends Domain<Integer> {

    private HashSet<Integer> domain_ = new HashSet<>();

    public IntDomain(Integer min_, Integer max_) {
        for (int i = min_; i < max_; i++) {
            domain_.add(i);
        }
    }

    public IntDomain(Collection<Integer> domain_) {
        this.domain_ = new HashSet<>();
        this.domain_.addAll(domain_);
    }

    @Override
    public boolean contains(Integer value) {
        return domain_.contains(value);
    }

    @Override
    public int size() {
        return domain_.size();
    }

    @Override
    public Collection<Integer> getDomainElements() {
        return domain_;
    }

    @Override
    public Integer nextValue(Integer value) {
        ArrayList<Integer> domain = new ArrayList<>();
        domain.addAll(domain_);
        Collections.sort(domain);
        int idx = BinarySearch.search(domain, value);
        if (idx < domain.size() - 1) {
            return domain.get(idx + 1);
        }
        return null;
    }

    @Override
    public Integer prevValue(Integer value) {
        ArrayList<Integer> domain = new ArrayList<>();
        domain.addAll(domain_);
        Collections.sort(domain);
        int idx = BinarySearch.search(domain, value);
        if ((idx < domain.size()) && (idx > 0)) {
            return domain.get(idx - 1);
        }
        return null;
    }

    @Override
    public void add(Integer value) {
        domain_.add(value);
    }

    @Override
    public void add(IDomain<Integer> domain) {
        domain_.addAll(domain.getDomainElements());
    }

    @Override
    public void remove(Integer value) {
        domain_.remove(value);
    }

    @Override
    public void remove(IDomain<Integer> domain) {
        domain_.removeAll(domain.getDomainElements());
    }
}
