package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;

import java.util.HashSet;

/***
 * contains all of constraints that must be satisfied
 * (has value of YES with solution)
 */
public interface ICPModel {
    /***
     * re-open model to modifying
     */
    public void open();

    /***
     * close model and deny all change
     */
    public void close();

    /***
     * add new constraint (and all related ValueEntity, of course) to model
     */
    public void post(IConstraintCP c);

    public void addValueEntity(IValueEntityCP e);
    public void addVariable(IVarCP var);

    /***
     * get model's current state (i.e. OPEN or CLOSE)
     * @return model's current state
     */
    public EModelState getState();

    /***
     * Link this model with IMetaSearchEngine se
     * @param se
     */
    public void setMetaSearchEngine(IMetaSearchEngine se);

    /***
     * Link this model with IPropagationEngineCP pe
     * @param pe
     */
    public void setPropagationEngine(IPropagationEngineCP pe);

    public HashSet<IVarCP> getVariables();
    public HashSet<IConstraintCP> getConstraints();
}
