package constraintprogramming.constraintmodel.invariant.function.arithm;

import constraintprogramming.constraintmodel.core.datatype.IDecisionEntityCP;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IntDomain;
import constraintprogramming.constraintmodel.invariant.function.AFunctionCP;
import constraintprogramming.constraintmodel.invariant.function.IFunctionCP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class FunctionAdd extends AFunctionCP
    implements IFunctionCP {

    private IValueEntityCP e1;
    private IValueEntityCP e2;

    public FunctionAdd(IDecisionEntityCP e1, IDecisionEntityCP e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.value = null;
        ArrayList<Integer> d1 = (ArrayList) e1.getDomain();
        ArrayList<Integer> d2 = (ArrayList) e2.getDomain();
        HashSet<Integer> domain = new HashSet<>();
        for (int i = 0; i < d1.size(); i++) {
            for (int j = 0; j < d2.size(); j++) {
                domain.add(d1.get(i) + d2.get(j));
            }
        }
        this.domain_ = new IntDomain(domain);
    }
}
