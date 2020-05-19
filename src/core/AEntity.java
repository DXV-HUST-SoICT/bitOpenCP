package core;

/***
 * Implements core methods of IEntity
 */
public abstract class AEntity<T> implements IEntity<T> {

    T id;

    @Override
    public T getId() {
        return this.id;
    }

    @Override
    public void setId(T id) {
        this.id = id;
    }
}
