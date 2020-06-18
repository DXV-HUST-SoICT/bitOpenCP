package constraintprogramming.propagationengine.pruningstack;

import constraintprogramming.constraintmodel.core.domain.Domain;
import constraintprogramming.constraintmodel.variable.IVarCP;

import java.util.HashMap;
import java.util.HashSet;

public class PruningList {
    public HashMap<IVarCP, Domain> list = new HashMap<>();
    public <T> void addValue(IVarCP<T> var, T val) {
        if (!list.containsKey(var)) {
            list.put(var, new Domain());
        }
        list.get(var).add(val);
    }
}
