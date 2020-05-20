package constraintprogramming.constraintmodel.invariant.constraint;

import constraintprogramming.constraintmodel.core.datatype.ESatisfaction;
import constraintprogramming.constraintmodel.invariant.IInvariantCP;

/***
 * Model's constraint
 */
public interface IConstraintCP
        extends IInvariantCP<ESatisfaction> {
    /***
     * Check if constraint is satisfied with current solution family
     * @return YES if constraint is satisfied
     * @return NO if constraint isn't satisfied
     * @return null if uncertain
     */
    public ESatisfaction isSatisfied();
}
