package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.SelectionStrategy;
import Problems.Function;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Elitism extends SelectionStrategy {

    public Elitism(int qParentsToSelect, boolean minimizing){
        this.qParentsToSelect = qParentsToSelect;
        this.minimizing = minimizing;
    }

    @Override
    public Individual[] selectParents(Individual[] population, Function function) {
        Individual[] elite = new Individual[qParentsToSelect];

        if(this.minimizing){
            Arrays.sort(population, new Comparator<Individual>() {
                @Override
                public int compare(Individual o1, Individual o2) {
                    double diff = o1.evaluateFitness(function) - o2.evaluateFitness(function);
                    return  diff > 0? 1: diff < 0? -1: 0;
                }
            });
        }
        else{
            Arrays.sort(population, new Comparator<Individual>() {
                @Override
                public int compare(Individual o1, Individual o2) {
                    double diff = o2.evaluateFitness(function) - o1.evaluateFitness(function);
                    return  diff > 0? 1: diff < 0? -1: 0;
                }
            });
        }


        for(int i = 0; i < qParentsToSelect; i++)
            elite[i] = population[i];

        return elite;
    }
}
