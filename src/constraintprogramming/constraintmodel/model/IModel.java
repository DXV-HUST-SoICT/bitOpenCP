package constraintprogramming.constraintmodel.model;

import constraintprogramming.constraintmodel.core.datatype.EModelState;

/***
 * contains all of constraints that must be satisfied
 * (has value of YES with solution)
 */
public interface IModel {
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
    public void post();

    /***
     * get model's current state (i.e. OPEN or CLOSE)
     * @return model's current state
     */
    public EModelState getState();
}
