package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.SatisfactionDomain;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;

import java.util.HashSet;

public class CPModel extends ACPModel implements ICPModel {

    private HashSet<IConstraintCP> setConstraint_ = new HashSet<>();
    private HashSet<IValueEntityCP> setValueEntity_ = new HashSet<>();
    private HashSet<IVarCP> setVar_ = new HashSet<>();
    private IMetaSearchEngine se;
    private IPropagationEngineCP pe;

    void ICPModel() {

    }

    public void addValueEntity(IValueEntityCP e) {
        if (setValueEntity_.contains(e)) {
            return;
        }
        setValueEntity_.add(e);
        if (e instanceof IVarCP) {
            setVar_.add((IVarCP) e);
        } else {
            HashSet<IValueEntityCP> t = e.getAffectingValueEntities();
            for (IValueEntityCP i : t) {
                addValueEntity(i);
            }
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
        HashSet<IVarCP> res = new HashSet<>();
        res.addAll(setVar_);
        return res;
    }

    @Override
    public HashSet<IConstraintCP> getConstraints() {
        HashSet<IConstraintCP> res = new HashSet<>();
        res.addAll(setConstraint_);
        return res;
    }
}
