package core;

public interface IEntity<T> {
    public void setId(T id);
    public T getId();
}
