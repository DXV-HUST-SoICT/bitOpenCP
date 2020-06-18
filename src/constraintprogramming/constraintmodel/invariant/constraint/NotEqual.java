package constraintprogramming.constraintmodel.invariant.constraint;

import constraintprogramming.constraintmodel.core.datatype.ESatisfaction;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.propagationengine.IAC3Pruning;
import core.IValueEntity;

import java.util.HashSet;

public class NotEqual extends AConstraintCP implements IConstraintCP, IAC3Pruning {

    private IValueEntityCP x1;
    private IValueEntityCP x2;

    public NotEqual(IValueEntityCP x1, IValueEntityCP x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public IDomain<ESatisfaction> getDomain() {
        return null;
    }

    @Override
    public void setDomain(IDomain<ESatisfaction> domain) {
        this.domain_ = domain;
    }

    @Override
    public boolean isAssigned() {
        return false;
    }

    @Override
    public IDomain<ESatisfaction> bottumUpPruning() {
        return null;
    }

    @Override
    public IDomain<ESatisfaction> topDownPruning() {
        return null;
    }

    @Override
    public HashSet<IValueEntityCP> getAffectingValueEntities() {
        return null;
    }
}
