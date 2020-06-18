package constraintprogramming.solver;

import constraintprogramming.searchengine.solution.Solution;

import java.util.ArrayList;

public interface ISolver {
    public void stateCM();
    public void declareMSE();
    public void solve();
    public ArrayList<Solution> getSolution();
}
