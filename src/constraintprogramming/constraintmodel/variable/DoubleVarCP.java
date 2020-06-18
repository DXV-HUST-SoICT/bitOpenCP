package constraintprogramming.constraintmodel.variable;

import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.propagationengine.IAC3Pruning;

import java.util.HashSet;

public class DoubleVarCP extends AVarCP<Double> implements IAC3Pruning {
    @Override
    public IDomain<Double> getDomain() {
        return null;
    }

    @Override
    public void setDomain(IDomain<Double> domain) {
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
