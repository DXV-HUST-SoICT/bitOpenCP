package constraintprogramming.constraintmodel.invariant.constraint;

import constraintprogramming.constraintmodel.constant.ConstantCP;
import constraintprogramming.constraintmodel.core.datatype.ESatisfaction;
import constraintprogramming.constraintmodel.core.datatype.IDecisionEntityCP;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.propagationengine.IAC3Pruning;
import core.IValueEntity;

import java.util.HashSet;

public class NotEqual extends AConstraintCP implements IConstraintCP, IAC3Pruning {

    private IValueEntityCP x1;
    private IValueEntityCP x2;
    HashSet<IValueEntityCP> affectingValueEntitiesSet;

    public NotEqual(IValueEntityCP x1, IValueEntityCP x2) {
        this.x1 = x1;
        this.x2 = x2;
        affectingValueEntitiesSet = new HashSet<>();
        affectingValueEntitiesSet.add(x1);
        affectingValueEntitiesSet.add(x2);
    }

    @Override
    public IDomain<ESatisfaction> getDomain() {
        return this.domain_;
    }

    @Override
    public void setDomain(IDomain<ESatisfaction> domain) {
        this.domain_ = domain;
    }

    @Override
    public boolean isAssigned() {
        return ((x1 instanceof ConstantCP) || (((IDecisionEntityCP) x1).isAssigned()))
                && ((x2 instanceof ConstantCP) || (((IDecisionEntityCP) x2).isAssigned()));
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
        HashSet<IValueEntityCP> res = new HashSet<>();
        res.addAll(affectingValueEntitiesSet);
        return res;
    }

    @Override
    public ESatisfaction getValue() {
        if (this.isAssigned()) {
            if (x1.getValue() != x2.getValue()) {
                return ESatisfaction.TRUE;
            } else {
                return ESatisfaction.FALSE;
            }
        } else {
            return this.value;
        }
    }
}
