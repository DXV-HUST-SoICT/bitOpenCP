package constraintprogramming.searchengine.metasearchengine;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.solution.Solution;

import java.util.ArrayList;

public interface IMetaSearchEngine {
    /***
     * Link this se with PropagationEngine pe
     * @param pe
     */
    public void setPropagationEngine(IPropagationEngineCP pe);

    /***
     * Link this se with IModel
     * @param cm
     */
    public void setConstraintModel(ICPModel cm);

    /***
     * Run search engine
     */
    public void run();

    /***
     * Return solution
     */
    public ArrayList<Solution> getSolution();
}
