package test;

import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.constraintmodel.core.domain.IntDomain;
import constraintprogramming.constraintmodel.invariant.constraint.IConstraintCP;
import constraintprogramming.constraintmodel.invariant.constraint.NotEqual;
import constraintprogramming.constraintmodel.invariant.function.IFunctionCP;
import constraintprogramming.constraintmodel.invariant.function.arithm.FunctionAdd;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.constraintmodel.variable.IntVarCP;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        IVarCP x = new IntVarCP();
        IDomain dx = new IntDomain(1, 10);
        for (Object i : dx.getDomainElements()) {
            System.out.print(i + " ");
        }
        System.out.println();
        x.setDomain(dx);
        IVarCP y = new IntVarCP();
        IDomain dy = new IntDomain(2, 7);
        for (Object i : dy.getDomainElements()) {
            System.out.print(i + " ");
        }
        System.out.println();
        y.setDomain(dy);
        IFunctionCP f = new FunctionAdd(x, y);
        ArrayList<Integer> df = new ArrayList<>();
        df.addAll(f.getDomainElements());
        for (int i = 0; i < df.size(); i++) {
            System.out.print(df.get(i) + " ");
        }
        System.out.println();

        IConstraintCP c;

        dx = new IntDomain(1, 2);
        x.setDomain(dx);
        dy = new IntDomain(1, 2);
        y.setDomain(dy);
        c = new NotEqual(x, y);
        for (Object i : c.getDomainElements()) {
            System.out.print(i + " ");
        }
        System.out.println();

        dx = new IntDomain(2, 3);
        x.setDomain(dx);
        dy = new IntDomain(1, 2);
        y.setDomain(dy);
        c = new NotEqual(x, y);
        for (Object i : c.getDomainElements()) {
            System.out.print(i + " ");
        }
        System.out.println();

        dx = new IntDomain(1, 3);
        x.setDomain(dx);
        dy = new IntDomain(1, 2);
        y.setDomain(dy);
        c = new NotEqual(x, y);
        for (Object i : c.getDomainElements()) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
