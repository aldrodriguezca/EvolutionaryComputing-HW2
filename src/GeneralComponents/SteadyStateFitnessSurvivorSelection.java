package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.ReplacementStrategy;
import Problems.Function;

import java.util.Arrays;
import java.util.Comparator;

public class SteadyStateFitnessSurvivorSelection extends ReplacementStrategy {
    int lambda, mu;

    public SteadyStateFitnessSurvivorSelection(int mu, int lambda){
        this.mu = mu;
        this.lambda = lambda;
    }

    public Individual[] mergePopulation(Individual[] parents, Individual[] offspring, Function function){
        Individual[] nextGeneration = new Individual[mu];
        Individual[] totalPopulation = new Individual[parents.length + offspring.length];

        int index;
        for(int i = 0; i < parents.length; i++)
            totalPopulation[i] = parents[i];
        for(int i = 0; i < offspring.length; i++){
            index = parents.length + i;
            totalPopulation[index] = offspring[i];
        }

        Arrays.sort(totalPopulation, new Comparator<Individual>() {
            @Override
            public int compare(Individual o1, Individual o2) {
                double diff = o2.evaluateFitness(function) - o1.evaluateFitness(function);
                return  diff > 0? 1: diff < 0? -1: 0;
            }
        });

        for(int i = 0; i < mu; i++){
            nextGeneration[i] = totalPopulation[i];
        }

        return nextGeneration;
    }

    @Override
    public Individual[] selectSurvivals(Individual[] parents, Individual[] offspring, Function function) {
        return mergePopulation(parents, offspring, function);
    }
}
