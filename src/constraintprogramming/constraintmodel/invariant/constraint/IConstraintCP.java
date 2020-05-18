package constraintprogramming.constraintmodel.invariant.constraint;

import constraintprogramming.constraintmodel.core.datatype.Satisfaction;
import constraintprogramming.constraintmodel.invariant.IInvariantCP;

public interface IConstraintCP
        extends IInvariantCP<Satisfaction> {
    public Satisfaction isSastified();
    public void reportPruning();
}
