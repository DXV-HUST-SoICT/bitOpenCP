package constraintprogramming.constraintmodel.variable;

import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;

import java.util.HashSet;

public class IntVarCP extends AVarCP<Integer> {

    @Override
    public void setDomain(IDomain<Integer> domain) {
        this.domain_ = domain;
    }

    @Override
    public void prune() {

    }

    @Override
    public HashSet<IValueEntityCP> getAffectValueEntity() {
        return new HashSet<>();
    }
}
