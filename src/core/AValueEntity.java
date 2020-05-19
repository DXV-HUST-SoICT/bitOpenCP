package core;

/***
 * Implements core methods of IValueEntity
 * @param <T> Value type
 */
public abstract class AValueEntity<T> extends ABasicEntity
    implements IValueEntity<T> {

    protected T value;

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
