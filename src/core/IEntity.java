package core;

/***
 *
 * @param <T> id type
 */
public interface IEntity<T> {

    /***
     * set object's id
     * @param id
     */
    public void setId(T id);

    /***
     *
     * @return object's id
     */
    public T getId();

    public void setName(String name);

    public String getName();
}
