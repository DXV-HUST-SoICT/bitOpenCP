package constraintprogramming.constraintmodel.invariant.constraint;

import constraintprogramming.constraintmodel.core.datatype.Satisfaction;
import constraintprogramming.constraintmodel.invariant.AInvariantCP;

public abstract class AConstraintCP extends AInvariantCP<Satisfaction>
        implements IConstraintCP {
    public Satisfaction isSastified() {
        return this.getValue();
    }
}
