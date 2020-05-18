package core;

public interface IValueEntity<T> extends IBasicEntity {
    public T getValue();
    public void setValue(T value);
}
