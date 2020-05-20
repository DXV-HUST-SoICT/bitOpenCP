package constraintprogramming.constraintmodel.invariant.constraint;

import constraintprogramming.constraintmodel.core.datatype.ESatisfaction;
import constraintprogramming.constraintmodel.invariant.AInvariantCP;

public abstract class AConstraintCP extends AInvariantCP<ESatisfaction>
        implements IConstraintCP {

    ESatisfaction value;

    @Override
    public ESatisfaction isSatisfied() {
        return value;
    }
}
