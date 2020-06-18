package constraintprogramming.searchengine.solution;

import constraintprogramming.constraintmodel.variable.IVarCP;

public interface ISolution {
    public <T> void assign(IVarCP<T> x, T v);
    public <T> T getSolution(IVarCP<T> x);
}
