package constraintprogramming.searchengine.taskstack;

import constraintprogramming.constraintmodel.core.domain.IDomain;
import constraintprogramming.constraintmodel.variable.IVarCP;

import java.util.HashMap;

public class Branch {
    public HashMap<IVarCP, IDomain> newDomain = new HashMap<>();
}
