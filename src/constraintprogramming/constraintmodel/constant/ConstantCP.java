package constraintprogramming.constraintmodel.constant;

import constraintprogramming.constraintmodel.core.datatype.AValueEntityCP;
import constraintprogramming.constraintmodel.core.datatype.IValueEntityCP;

import java.util.HashSet;

/***
 * Model's constant factors
 * @param <T>
 */
public class ConstantCP<T> extends AValueEntityCP<T>
    implements IValueEntityCP<T> {
    @Override
    public HashSet<IValueEntityCP> getAffectValueEntity() {
        return new HashSet<>();
    }
}
