package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.SatisfactionDomain;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.propagationengine.IAC3Pruning;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;

import java.util.HashSet;

public class CPModel extends ACPModel implements ICPModel {

    HashSet<IConstraintCP> setConstraint_ = new HashSet<>();
    HashSet<IValueEntityCP> setValueEntity_ = new HashSet<>();
    IMetaSearchEngine se;
    IPropagationEngineCP pe;

    void ICPModel() {

    }

    public void addValueEntity(IValueEntityCP e) {
        if (setValueEntity_.contains(e)) {
            return;
        }
        setValueEntity_.add(e);
        HashSet<IValueEntityCP> t = e.getAffectingValueEntities();
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
        setConstraint_.add(c);
    }

    @Override
    public void setMetaSearchEngine(IMetaSearchEngine se) {
        this.se = se;
    }

    @Override
    public void setPropagationEngine(IPropagationEngineCP pe) {
        this.pe = pe;
    }

    @Override
    public HashSet<IVarCP> getVariables() {
        return null;
    }

    @Override
    public HashSet<IConstraintCP> getConstraints() {
        return null;
    }
}
