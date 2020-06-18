package constraintprogramming.constraintmodel.core.domain;

import constraintprogramming.constraintmodel.core.datatype.ESatisfaction;

import java.util.Collection;
import java.util.HashSet;

public class SatisfactionDomain extends ADomain<ESatisfaction> implements IDomain<ESatisfaction> {

    HashSet<ESatisfaction> domain_ = new HashSet<>();

    public SatisfactionDomain(int mask) {
        if (mask % 2 == 1) {
            domain_.add(ESatisfaction.FALSE);
        }
        if (mask / 2 == 1) {
            domain_.add(ESatisfaction.TRUE);
        }
    }

    @Override
    public boolean contains(ESatisfaction value) {
        return domain_.contains(value);
    }

    @Override
    public int size() {
        return domain_.size();
    }

    @Override
    public Collection<ESatisfaction> getDomainElements() {
        return domain_;
    }

    @Override
    public ESatisfaction nextValue(ESatisfaction value) {
        if (!domain_.contains(value) || domain_.size() < 2) {
            return null;
        }
        if (value == ESatisfaction.FALSE) {
            return value.TRUE;
        } else {
            return null;
        }
    }

    @Override
    public ESatisfaction prevValue(ESatisfaction value) {
        if (!domain_.contains(value) || domain_.size() < 2) {
            return null;
        }
        if (value == ESatisfaction.TRUE) {
            return value.FALSE;
        } else {
            return null;
        }
    }

    @Override
    public void add(ESatisfaction value) {
        domain_.add(value);
    }

    @Override
    public void add(IDomain<ESatisfaction> domain) {
        domain_.addAll(domain.getDomainElements());
    }

    @Override
    public void remove(ESatisfaction value) {
        domain_.remove(value);
    }

    @Override
    public void remove(IDomain<ESatisfaction> domain) {
        domain_.removeAll(domain.getDomainElements());
    }
}
