package constraintprogramming.workloadmanager;

import constraintprogramming.searchengine.solution.Solution;

import java.util.ArrayList;

public interface IWorkloadManager {

    public void run();
    public void createAssociate();
    public ArrayList<Solution> getSolution();
}
