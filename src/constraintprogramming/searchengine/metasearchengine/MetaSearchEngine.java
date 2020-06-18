package constraintprogramming.searchengine.metasearchengine;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.searchengine.ISearchEngine;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.searchengine.taskstack.TaskStack;

import java.util.ArrayList;

public class MetaSearchEngine extends AMetaSearchEngine implements IMetaSearchEngine {

    IPropagationEngineCP pe;
    ICPModel cm;
    TaskStack taskStack = new TaskStack();
    ArrayList<ISearchEngine> se;
    ArrayList<Solution> solution = new ArrayList<>();

    public MetaSearchEngine(ArrayList<ISearchEngine> se) {
        this.se = se;
    }

    @Override
    public void setPropagationEngine(IPropagationEngineCP pe) {
        this.pe = pe;
    }

    @Override
    public void setConstraintModel(ICPModel cm) {
        this.cm = cm;
    }

    @Override
    public void run() {
        for (int i = 0; i < se.size(); i++) {
            solution = se.get(i).search(solution);
        }
    }

    @Override
    public ArrayList<Solution> getSolution() {
        return solution;
    }
}
