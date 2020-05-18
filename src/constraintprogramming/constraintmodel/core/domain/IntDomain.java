package constraintprogramming.constraintmodel.core.domain;

import utils.algorithms.BinarySearch;

import java.util.*;

public class IntDomain extends ADomain<Integer> implements IDomain<Integer> {

    private ArrayList<Integer> domain_;

    public IntDomain(Integer min_, Integer max_) {
        domain_ = new ArrayList<>();
        for (int i = min_; i < max_; i++) {
            domain_.add(i);
        }
    }

    public IntDomain(Collection<Integer> domain_) {
        this.domain_ = new ArrayList<>();
        this.domain_.addAll(domain_);
        Collections.sort(this.domain_);
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
    public Collection<Integer> domain() {
        return domain_;
    }

    @Override
    public Integer nextValue(Integer value) {
        int idx = BinarySearch.search(domain_, value);
        if (idx < domain_.size() - 1) {
            return domain_.get(idx + 1);
        }
        return null;
    }

    @Override
    public Integer prevValue(Integer value) {
        int idx = BinarySearch.search(domain_, value);
        if ((idx < domain_.size()) && (idx > 0)) {
            return domain_.get(idx - 1);
        }
        return null;
    }
}
