package constraintprogramming.constraintmodel.core.domain;

import java.util.Collection;

/***
 * Domain of value (i.e. set of value)
 * @param <T>
 */
public interface IDomain<T> {
    /***
     * check if value in domain
     * @param value
     * @return true/false
     */
    public boolean contains(T value);

    /***
     * size of domain (i.e. number of values)
     * @return
     */
    public int size();

    /***
     *
     * @return all of values of domain
     */
    public Collection<T> getDomain();

    /***
     *
     * @param value
     * @return next value of current value
     */
    public T nextValue(T value);

    /***
     * previous value of current value
     * @param value
     * @return
     */
    public T prevValue(T value);

    /***
     * add value to domain
     * @param value
     */
    public void add(T value);

    /***
     * merge domain of value to this domain
     * @param domain
     */
    public void add(IDomain<T> domain);

    /***
     * add value to domain
     * @param value
     */
    public void remove(T value);

    /***
     * split domain of value to this domain
     * @param domain
     */
    public void remove(IDomain<T> domain);
}
