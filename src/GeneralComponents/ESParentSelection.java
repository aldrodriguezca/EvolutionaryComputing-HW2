package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.SelectionStrategy;
import Problems.Function;

public class ESParentSelection extends SelectionStrategy {

    public ESParentSelection(int qParentsToSelect){
        this.qParentsToSelect = qParentsToSelect;
    }

    @Override
    public Individual[] selectParents(Individual[] population, Function function) {
        Individual[] selectedParents = new Individual[qParentsToSelect];

        for(int i = 0; i < qParentsToSelect ; i ++)
            selectedParents[i] =  population[(int)Math.random()*population.length];

        return selectedParents;

    }
}
