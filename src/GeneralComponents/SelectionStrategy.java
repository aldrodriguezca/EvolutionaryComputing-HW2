package GeneralComponents;

import GeneralComponents.Individual;
import Problems.Function;

public abstract class SelectionStrategy {
    protected int qParentsToSelect;
    protected boolean minimizing;

    //Parents
    public abstract Individual[] selectParents(Individual[] population, Function function);
}
