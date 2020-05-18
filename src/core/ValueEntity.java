package core;

public abstract class ValueEntity<T> extends BasicEntity
    implements IValueEntity<T> {
    T value;

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
