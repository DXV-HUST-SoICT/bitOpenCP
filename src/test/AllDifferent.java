package test;

import constraintprogramming.constraintmodel.core.domain.IntDomain;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.invariant.constraint.NotEqual;
import constraintprogramming.constraintmodel.model.CPModel;
import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.constraintmodel.variable.IntVarCP;
import constraintprogramming.propagationengine.AC3PropagationEngine;
import constraintprogramming.searchengine.metasearchengine.MetaSearchEngine;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.workloadmanager.WorkloadManager;

import java.util.ArrayList;

public class AllDifferent {
    public static void main(String[] args) {
        int N = 8;
        ICPModel cm = new CPModel();
        IVarCP[] x = new IVarCP[N];
        for (int i = 0; i < N; i++) {
            x[i] = new IntVarCP();IntDomain d = new IntDomain(0, N);
            x[i].setDomain(d);
            x[i].setName("x_" + i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                IConstraintCP c = new NotEqual(x[i], x[j]);
                c.setName("x_" + i + " != x_" + j);
                cm.post(c);
            }
        }
        AC3PropagationEngine pe = new AC3PropagationEngine();
        MetaSearchEngine se = new MetaSearchEngine();
        WorkloadManager wm = new WorkloadManager(pe, cm, se);
        wm.run();
        ArrayList<Solution> solution = wm.getSolution();
        for (int i = 0; i < solution.size(); i++) {
            System.out.println("Solution " + i + ":\n" + solution.get(i).toString());
        }
    }
}
