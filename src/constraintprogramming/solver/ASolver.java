package constraintprogramming.solver;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.workloadmanager.WorkloadManager;

import java.util.ArrayList;

public abstract class ASolver implements ISolver {
    private ArrayList<ICPModel> cm = new ArrayList<>();
    private ArrayList<IMetaSearchEngine> se = new ArrayList<>();
    private ArrayList<IPropagationEngineCP> pe = new ArrayList<>();
    private ArrayList<Solution> solutions;
    @Override
    public void solve() {
        WorkloadManager wm = new WorkloadManager(pe, cm, se);
        wm.run();
        solutions = wm.getSolution();
    }

    @Override
    public ArrayList<Solution> getSolution() {
        return this.solutions;
    }
}
