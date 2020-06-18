package constraintprogramming.propagationengine;

import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;
import constraintprogramming.constraintmodel.core.domain.IDomain;

import java.util.ArrayList;
import java.util.HashSet;

public interface IAC3Pruning {
    public IDomain bottumUpPruning();

    public IDomain topDownPruning();
}
