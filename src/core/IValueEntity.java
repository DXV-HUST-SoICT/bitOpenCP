package core;

/***
 * Basic entities has value
 * @param <T> Value type
 */
public interface IValueEntity<T> extends IBasicEntity {

    /***
     *
     * @return object's value
     */
    public T getValue();

    /***
     * set object's value
     * @param value
     */
    public void setValue(T value);
}
