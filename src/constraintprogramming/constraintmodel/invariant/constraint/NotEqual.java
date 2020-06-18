package constraintprogramming.constraintmodel.invariant.constraint;

import constraintprogramming.constraintmodel.constant.ConstantCP;
import constraintprogramming.constraintmodel.core.datatype.ESatisfaction;
import constraintprogramming.constraintmodel.core.datatype.IDecisionEntityCP;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.Domain;
import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.propagationengine.IAC3Pruning;
import core.IValueEntity;

import java.util.ArrayList;
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
        this.domain_ = new Domain<ESatisfaction>();
        ArrayList<Integer> d1 = new ArrayList<>();
        ArrayList<Integer> d2 = new ArrayList<>();
        if (x1 instanceof IDecisionEntityCP) {
            d1.addAll(((IDecisionEntityCP) x1).getDomainElements());
        } else {
            d1.add((Integer) x1.getValue());
        }
        if (x2 instanceof IDecisionEntityCP) {
            d2.addAll(((IDecisionEntityCP) x2).getDomainElements());
        } else {
            d2.add((Integer) x2.getValue());
        }
        for (int i = 0; i < d1.size(); i++) {
            for (int j = 0; j < d2.size(); j++) {
                if (d1.get(i) == d2.get(j)) {
                    this.domain_.add(ESatisfaction.TRUE);
                } else {
                    this.domain_.add(ESatisfaction.FALSE);
                }
                if (this.domain_.size() == 2) {
                    break;
                }
            }
            if (this.domain_.size() == 2) {
                break;
            }
        }
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
