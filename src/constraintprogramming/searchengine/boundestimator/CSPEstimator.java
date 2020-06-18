package constraintprogramming.searchengine.boundestimator;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.searchengine.solution.ISolution;

public class CSPEstimator implements IBoundEstimator {
    @Override
    public boolean isBetter(ICPModel model, ISolution bestSolution) {
        return bestSolution == null;
    }
}
