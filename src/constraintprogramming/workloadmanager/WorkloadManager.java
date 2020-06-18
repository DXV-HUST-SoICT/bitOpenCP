package constraintprogramming.workloadmanager;

import constraintprogramming.constraintmodel.model.ICPModel;
import constraintprogramming.propagationengine.IPropagationEngineCP;
import constraintprogramming.searchengine.metasearchengine.IMetaSearchEngine;
import constraintprogramming.searchengine.solution.Solution;

import java.util.ArrayList;

public class WorkloadManager extends AWorkloadManager implements IWorkloadManager {

    protected int n;
    protected ArrayList<IPropagationEngineCP> pe = new ArrayList<>();
    protected ArrayList<ICPModel> cm = new ArrayList<>();
    protected ArrayList<IMetaSearchEngine> se = new ArrayList<>();

    public WorkloadManager(IPropagationEngineCP pe, ICPModel cm, IMetaSearchEngine se) {
        this.pe.add(pe);
        this.cm.add(cm);
        this.se.add(se);
        createAssociate();
    }

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

    @Override
    public ArrayList<Solution> getSolution() {
        return se.get(0).getSolution();
    }
}
