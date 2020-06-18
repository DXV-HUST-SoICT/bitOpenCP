package constraintprogramming.constraintmodel.invariant.function.arithm;

import constraintprogramming.constraintmodel.constant.ConstantCP;
import constraintprogramming.constraintmodel.core.datatype.IDecisionEntityCP;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.constraintmodel.core.domain.IntDomain;
import constraintprogramming.constraintmodel.invariant.function.AFunctionCP;
import constraintprogramming.constraintmodel.invariant.function.IFunctionCP;
import constraintprogramming.propagationengine.IAC3Pruning;

import java.util.ArrayList;
import java.util.HashSet;

public class FunctionAdd extends AFunctionCP<Integer>
    implements IFunctionCP<Integer>, IAC3Pruning {

    private IValueEntityCP e1;
    private IValueEntityCP e2;

    public FunctionAdd(IValueEntityCP e1, IValueEntityCP e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.value = null;
        ArrayList<Integer> d1 = new ArrayList<>();
        ArrayList<Integer> d2 = new ArrayList<>();
        if (e1 instanceof IDecisionEntityCP) {
            d1.addAll(((IDecisionEntityCP) e1).getDomainElements());
        } else {
            d1.add((Integer) e1.getValue());
        }
        if (e2 instanceof IDecisionEntityCP) {
            d2.addAll(((IDecisionEntityCP) e2).getDomainElements());
        } else {
            d2.add((Integer) e2.getValue());
        }
        HashSet<Integer> domain = new HashSet<>();
        for (int i = 0; i < d1.size(); i++) {
            for (int j = 0; j < d2.size(); j++) {
                domain.add(d1.get(i) + d2.get(j));
            }
        }
        this.domain_ = new IntDomain(domain);
    }

    @Override
    public IDomain getDomain() {
        return domain_;
    }

    @Override
    public void setDomain(IDomain domain) {
        this.domain_ = domain;
    }

    @Override
    public boolean isAssigned() {
        return ((e1 instanceof ConstantCP) || (((IDecisionEntityCP) e1).isAssigned()))
                && ((e1 instanceof ConstantCP) || (((IDecisionEntityCP) e1).isAssigned()));
    }

    @Override
    public HashSet<IValueEntityCP> getAffectingValueEntities() {
        HashSet<IValueEntityCP> affectVE = new HashSet<>();
        affectVE.add(e1);
        affectVE.add(e2);
        return affectVE;
    }

    @Override
    public IDomain bottumUpPruning() {
        return null;
    }

    @Override
    public IDomain topDownPruning() {
        return null;
    }

    @Override
    public Integer getValue() {
        return (Integer) e1.getValue() + (Integer) e2.getValue();
    }
}
