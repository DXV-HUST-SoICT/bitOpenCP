package constraintprogramming.searchengine.searchengine;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.searchengine.taskstack.TaskStack;

import java.util.ArrayList;

public interface ISearchEngine {
    public ArrayList<Solution> search(ArrayList<Solution> curSolution);
}
