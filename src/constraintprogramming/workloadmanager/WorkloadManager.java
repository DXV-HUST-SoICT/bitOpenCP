package constraintprogramming.workloadmanager;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;

import java.util.ArrayList;

public class WorkloadManager extends AWorkloadManager implements IWorkloadManager {

    protected int n;
    protected ArrayList<IPropagationEngineCP> pe;
    protected ArrayList<ICPModel> cm;
    protected ArrayList<IMetaSearchEngine> se;

    public WorkloadManager(ArrayList<IPropagationEngineCP> pe, ArrayList<ICPModel> cm, ArrayList<IMetaSearchEngine> se) {
        this.pe = pe;
        this.cm = cm;
        this.se = se;
        createAssociate();
    }

    @Override
    public void run() {
        se.get(0).run();
    }

    @Override
    public void createAssociate() {
        this.n = Math.min(pe.size(), cm.size());
        this.n = Math.min(this.n, se.size());

        for (int i = 0; i < n; i++) {
            pe.get(i).setMetaSearchEngine(se.get(i));
            pe.get(i).setConstraintModel(cm.get(i));
            se.get(i).setPropagationEngine(pe.get(i));
            se.get(i).setConstraintModel(cm.get(i));
            cm.get(i).setMetaSearchEngine(se.get(i));
            cm.get(i).setPropagationEngine(pe.get(i));

            this.pe.add(pe.get(i));
            this.cm.add(cm.get(i));
            this.se.add(se.get(i));
        }
    }
}
