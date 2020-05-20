package constraintprogramming.constraintmodel.core.datatype;

import java.util.Collection;

/***
 * Model's factors can change value
 * @param <T>
 */
public interface IDecisionEntityCP<T> extends IValueEntityCP<T> {
    /***
     * Check if value in entity's domain
     * @param value
     * @return
     */
    public boolean inDomain(T value);

    /***
     * get entity's domain of value
     * @return
     */
    public Collection<T> getDomain();

    /***
     * Prune values constraint can be assigned
     */
    public void prune();
}
