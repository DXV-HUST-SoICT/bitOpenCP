package constraintprogramming.constraintmodel.core.datatype;

public interface IDecisionEntityCP<T> extends IValueEntityCP<T> {
    public boolean inDomain(T value);
}
