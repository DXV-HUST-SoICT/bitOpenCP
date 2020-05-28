package constraintprogramming.constraintmodel.core.datatype;

import core.IValueEntity;

import java.util.HashSet;

/***
 * Model's factors that can be assigned value
 * @param <T>
 */
public interface IValueEntityCP<T> extends IValueEntity<T> {
    public HashSet<IValueEntityCP> getAffectValueEntity();
}
