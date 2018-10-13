package ES;

import GeneralComponents.*;
import Problems.Function;

public class ES {

    private SelectionStrategy selectionStrategy;
    private RecombinationStrategy recombinationStrategy;
    private MutationStrategy mutationStrategy;
    private ReplacementStrategy replacementStrategy;

    private Individual[] population;

    Function function;

    public ES(SelectionStrategy selectionStrategy,
              RecombinationStrategy recombinationStrategy,
              MutationStrategy mutationStrategy,
              ReplacementStrategy replacementStrategy) {
        this.selectionStrategy = selectionStrategy;
        this.recombinationStrategy = recombinationStrategy;
        this.mutationStrategy = mutationStrategy;
        this.replacementStrategy = replacementStrategy;
    }

    public void evolution(int nIterations){
        Individual[] parents, offspring;

        for(int i = 0; i < nIterations; i++){

            parents = selectionStrategy.selectParents(population, function);


            if(replacementStrategy.getType().equals("plus")){

            }else{

            }

        }

    }

}
