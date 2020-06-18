package test;

import constraintprogramming.constraintmodel.core.domain.IntDomain;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.invariant.constraint.NotEqual;
import constraintprogramming.constraintmodel.model.CPModel;
import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IntVarCP;
import constraintprogramming.propagationengine.AC3PropagationEngine;
import constraintprogramming.searchengine.metasearchengine.MetaSearchEngine;
import constraintprogramming.searchengine.searchengine.CSPSearchEngine;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.workloadmanager.WorkloadManager;

import java.util.ArrayList;

public class Sudoku {

    public static void main(String[] args) {
        int M = 2;
        int N = M * M;
        ICPModel cm = new CPModel();
        IntVarCP[][] x = new IntVarCP[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                x[i][j] = new IntVarCP();
                IntDomain d = new IntDomain(0, N);
                x[i][j].setDomain(d);
                x[i][j].setName("x[" + i + ", " + j + "]");
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    IConstraintCP c;
                    c = new NotEqual(x[i][k], x[i][j]);
                    c.setName("x[" + i + ", " + k + "] != x["  + i + ", " + j + "]");
                    cm.post(c);
                    c = new NotEqual(x[k][i], x[j][i]);
                    cm.post(c);
                    c.setName("x[" + k + ", " + i + "] != x["  + j + ", " + i + "]");
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                for (int u = 0; u < M; u++) {
                    for (int v = 0; v < M; v++) {
                        for (int k = 0; k < M; k++) {
                            for (int h = 0; h < M; h++) {
                                if ((u != k) && (v != h)) {
                                    cm.post(new NotEqual(x[i * M + u][j * M + v], x[i * M + k][j * M + h]));
                                }
                            }
                        }
                    }
                }
            }
        }

//        cm.close();
//        cm.getState();
//        System.out.println(cm.getConstraints());
//        System.out.println(cm.getVariables());

        AC3PropagationEngine pe = new AC3PropagationEngine();
        MetaSearchEngine se = new MetaSearchEngine();
        WorkloadManager wm = new WorkloadManager(pe, cm, se);
        wm.run();
        ArrayList<Solution> solution = wm.getSolution();
        for (int i = 0; i < solution.size(); i++) {
            System.out.println("Solution " + i + ": " + solution.toString());
        }
    }
}
