package test;

import constraintprogramming.constraintmodel.constant.ConstantCP;
import constraintprogramming.constraintmodel.core.domain.IntDomain;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.invariant.constraint.NotEqual;
import constraintprogramming.constraintmodel.invariant.function.IFunctionCP;
import constraintprogramming.constraintmodel.invariant.function.arithm.FunctionAdd;
import constraintprogramming.constraintmodel.model.CPModel;
import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.constraintmodel.variable.IntVarCP;
import constraintprogramming.propagationengine.AC3PropagationEngine;
import constraintprogramming.searchengine.metasearchengine.MetaSearchEngine;
import constraintprogramming.searchengine.solution.Solution;
import constraintprogramming.workloadmanager.WorkloadManager;

import java.util.ArrayList;

public class NQueen {
    public static void main(String[] args) {
        int N = 7;
        ICPModel cm = new CPModel();
        IVarCP[] x = new IVarCP[N];
        for (int i = 0; i < N; i++) {
            x[i] = new IntVarCP();IntDomain d = new IntDomain(0, N);
            x[i].setDomain(d);
            x[i].setName("x_" + i);
            cm.addVariable(x[i]);
        }
        IFunctionCP[] c1 = new IFunctionCP[N];
        IFunctionCP[] c2 = new IFunctionCP[N];
        for (int i = 0; i < N; i++) {
            c1[i] = new FunctionAdd(x[i], new ConstantCP<Integer>(i));
            c2[i] = new FunctionAdd(x[i], new ConstantCP<Integer>(-i));
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                IConstraintCP c;
                c = new NotEqual(x[i], x[j]);
                c.setName("x_" + i + " != x_" + j);
                cm.post(c);
                c = new NotEqual(c1[i], c1[j]);
                c.setName("c1_" + i + " != c1_" + j);
                cm.post(c);
                c = new NotEqual(c2[i], c2[j]);
                c.setName("c2_" + i + " != c2_" + j);
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
