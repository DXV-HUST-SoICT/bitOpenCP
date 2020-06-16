package constraintprogramming.constraintmodel.variable;

import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;

import java.util.HashSet;

public class DoubleVarCP extends AVarCP<Double> {
    @Override
    public void setDomain(IDomain<Double> domain) {
        this.domain_ = domain;
    }

    @Override
    public int selfPruning() {

    }

    @Override
    public HashSet<IValueEntityCP> getAffectingValueEntities() {
        return new HashSet<>();
    }
}
