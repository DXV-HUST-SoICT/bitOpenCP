package constraintprogramming.searchengine.solution;

import constraintprogramming.constraintmodel.variable.IVarCP;

import java.util.HashMap;

public class Solution implements ISolution {

    private HashMap<IVarCP, Object> solution = new HashMap<>();

    public Solution() {

    }

    public Solution(IVarCP[] x, Object[] v) {
        for (int i = 0; i < x.length; i++) {
            assign(x[i], v[i]);
        }
    }

    @Override
    public <T> void assign(IVarCP<T> x, T v) {
        solution.put(x, v);
    }

    @Override
    public <T> T getSolution(IVarCP<T> x) {
        return (T) solution.get(x);
    }
}
