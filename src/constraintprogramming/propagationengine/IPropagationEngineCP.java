package constraintprogramming.propagationengine;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;

public interface IPropagationEngineCP {
    public void propagatePruning();

    /***
     * Link this pe with IMetaSearchEngine se
     * @param se
     */
    public void setMetaSearchEngine(IMetaSearchEngine se);

    /***
     * Link this pe with IModel
     * @param cm
     */
    public void setConstraintModel(ICPModel cm);

    public void revertPruning();
}
