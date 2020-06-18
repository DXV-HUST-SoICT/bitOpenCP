package core;

/***
 * Implements core methods of IEntity
 */
public abstract class AEntity<T> implements IEntity<T> {

    T id;
    String name;

    @Override
    public T getId() {
        return this.id;
    }

    @Override
    public void setId(T id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
