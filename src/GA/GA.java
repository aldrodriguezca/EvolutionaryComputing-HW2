package GA;

import GeneralComponents.*;
import Problems.Function;

public class GA<T> {
    private Individual[] population;
    private double variationOperatorsRate = 0.6;

    MutationStrategy mutationStrategy;
    RecombinationStrategy recombinationStrategy;
    SelectionStrategy parentSelectionStrategy;
    ReplacementStrategy replacementStrategy;

    Function function;

    //TODO: Generate random individuals for problem
    public GA(int popSize, Function function, double variationOperatorsRate){
        population = new Individual[popSize];
        this.function = function;
        this.variationOperatorsRate = variationOperatorsRate;
    }

    public GA(Individual[] initialPopulation, Function function, double variationOperatorsRate){
        this.population = initialPopulation;
        this.function = function;
        this.variationOperatorsRate = variationOperatorsRate;
    }

    public GA(Individual[] initialPopulation, Function function, MutationStrategy mutationStrategy, RecombinationStrategy recombinationStrategy,
              SelectionStrategy parentSelectionStrategy, ReplacementStrategy replacementStrategy){
        this.population = initialPopulation;

        this.function = function;
        this.mutationStrategy = mutationStrategy;
        this.recombinationStrategy = recombinationStrategy;
        this.parentSelectionStrategy = parentSelectionStrategy;
        this.replacementStrategy = replacementStrategy;
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

    public Individual[] evolve(int nIterations){
        Individual[] parents;
        Individual[] offspring;

        //TODO: Add probabilities of X over and mutation (for they both united)

        for(int i = 0; i < nIterations; i++){
            parents = parentSelectionStrategy.selectParents(population, function);

            if(Math.random() > variationOperatorsRate){
                offspring = recombinationStrategy.recombineParents(parents);
                offspring = mutationStrategy.mutate(offspring);
                //population = mergeOffspring(parents, offspring);
                population = replacementStrategy.selectSurvivals(parents, offspring, function);
            }
            System.out.println("F:");
            printPopulationFitness(population, function);
        }
        return population;
    }

    public void printPopulationFitness(Individual[] population, Function f){
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");

        for(int i = 0; i < population.length; i++){
            sb.append( population[i].evaluateFitness(f) + (i != population.length -1? ", " : " ]"));
        }

        System.out.println(sb.toString());

    }

}
