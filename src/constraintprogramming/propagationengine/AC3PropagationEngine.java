package constraintprogramming.propagationengine;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.constraintmodel.variable.IVarCP;
import constraintprogramming.propagationengine.pruningstack.PruningList;
import constraintprogramming.propagationengine.pruningstack.PruningStack;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;

public class AC3PropagationEngine extends APropagationEngineCP implements IPropagationEngineCP {

    private IMetaSearchEngine se;
    private ICPModel cm;

    PruningStack pruningStack = new PruningStack();

    @Override
    public void propagatePruning() {
        pruningStack.stack.add(new PruningList());
    }

    @Override
    public void setMetaSearchEngine(IMetaSearchEngine se) {
        this.se = se;
    }

    @Override
    public void setConstraintModel(ICPModel cm) {
        this.cm = cm;
    }

    @Override
    public void revertPruning() {
        PruningList list = pruningStack.stack.peek();
        for (IVarCP var : list.list.keySet()) {

            var.getDomain().add(list.list.get(var));
        }
        pruningStack.stack.pop();
    }
}
