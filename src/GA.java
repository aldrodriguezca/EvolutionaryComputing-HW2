public class GA<T> {
    private Individual[] population;

    MutationStrategy mutationStrategy;
    RecombinationStrategy recombinationStrategy;
    SelectionStrategy parentSelectionStrategy;
    ReplacementStrategy replacementStrategy;


    public GA(int popSize){
        population = new Individual[popSize];
    }

    public GA(int popSize, MutationStrategy mutationStrategy, RecombinationStrategy recombinationStrategy,
              SelectionStrategy parentSelectionStrategy, ReplacementStrategy replacementStrategy){
        population = new Individual[popSize];
        this.mutationStrategy = mutationStrategy;
        this.recombinationStrategy = recombinationStrategy;
        this.parentSelectionStrategy = parentSelectionStrategy;
        this.replacementStrategy = replacementStrategy;
    }


    private Individual[] mergeOffspring(Individual[] parents, Individual[] offspring){
        Individual[] newPopulation = new Individual[parents.length + offspring.length];



        return newPopulation;
    }

    void evolve(int nIterations){
        Individual[] parents;
        Individual[] offspring;

        for(int i = 0; i < nIterations; i++){
            parents = parentSelectionStrategy.selectParents(population);
            offspring = recombinationStrategy.mixParents(parents);
            //population = mergeOffspring(parents, offspring);
            population = replacementStrategy.selectSurvivals(parents, offspring);
        }
    }


    void evolve(){

    }

}
