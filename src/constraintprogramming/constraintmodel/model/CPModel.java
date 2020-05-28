package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.SatisfactionDomain;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;
import core.IValueEntity;

import java.util.HashSet;

public class CPModel extends ACPModel implements ICPModel {

    HashSet<IValueEntityCP> setValueEntity_;
    IMetaSearchEngine se;
    IPropagationEngineCP pe;

    void ICPModel() {
        setValueEntity_ = new HashSet<>();
    }

    public void addValueEntity(IValueEntityCP e) {
        if (setValueEntity_.contains(e)) {
            return;
        }
        setValueEntity_.add(e);
        HashSet<IValueEntityCP> t = e.getAffectValueEntity();
        for (IValueEntityCP i : t) {
            addValueEntity(i);
        }
    }

    @Override
    public void post(IConstraintCP c) {
        if (this.state_ == EModelState.CLOSE) {
            return;
        }
        addValueEntity(c);
        c.setDomain(new SatisfactionDomain(2));
    }

    @Override
    public void setMetaSearchEngine(IMetaSearchEngine se) {
        this.se = se;
    }

    @Override
    public void setPropagationEngine(IPropagationEngineCP pe) {
        this.pe = pe;
    }
}
