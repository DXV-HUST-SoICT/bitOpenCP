package constraintprogramming.constraintmodel.variable;

import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.propagationengine.IAC3Pruning;

import java.util.HashSet;

public class IntVarCP extends AVarCP<Integer> implements IAC3Pruning {

    @Override
    public IDomain<Integer> getDomain() {
        return this.domain_;
    }

    @Override
    public void setDomain(IDomain<Integer> domain) {
        this.domain_ = domain;
    }


    @Override
    public HashSet<IValueEntityCP> getAffectingValueEntities() {
        return new HashSet<>();
    }

    @Override
    public IDomain bottumUpPruning() {
        return null;
    }

    @Override
    public IDomain topDownPruning() {
        return null;
    }
}
