package constraintprogramming.searchengine.boundestimator;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.searchengine.solution.ISolution;

public interface IBoundEstimator {
    public boolean isBetter(ICPModel model, ISolution bestSolution);
}
