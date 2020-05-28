package constraintprogramming.propagationengine;

import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;

import java.util.ArrayList;
import java.util.HashSet;

public interface IAC3Pruning {
    public HashSet<HashSet<IValueEntityCP>> getArcRelationship();
}
