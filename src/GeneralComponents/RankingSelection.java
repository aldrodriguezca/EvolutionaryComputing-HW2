package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.SelectionStrategy;
import Problems.Function;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RankingSelection extends SelectionStrategy {

    private double[] probabilities;
    private double S;


    public RankingSelection(int qParentsToSelect){
        this.qParentsToSelect = qParentsToSelect;
        this.S = Math.random()+1;
    }

    public void computeProbabilities(Individual[] population){
        probabilities = new double[population.length];

        int mu = population.length;
        for(int i = 0; i < population.length; i++){
            //TODO: Check
            probabilities[i] = ((2-S)/ mu) + ((2*i * (S-1))/(mu*(mu-1)));
        }
    }

    @Override
    public Individual[] selectParents(Individual[] population, Function function) {
        Individual[] selectedParents = new Individual[qParentsToSelect];
        //TODO: Check
        Arrays.sort(population, new Comparator<Individual>() {
            @Override
            public int compare(Individual o1, Individual o2) {
                double diff = o1.evaluateFitness(function) - o2.evaluateFitness(function);
                return  diff > 0? 1: diff < 0? -1: 0;
            }
        });

        computeProbabilities(population);

        double r, a_i;
        int index;

        double[] a = new double[probabilities.length];

        for(int i = 0; i < probabilities.length; i++) {
            a[i] = 0;
            a[i] += probabilities[i];
        }

        for(int i = 0; i < qParentsToSelect; i++){
            r = Math.random();

            index = 0;
            a_i = 0;
            a_i += probabilities[0];
            while(  a[index] < r ){
                if(index +1 < probabilities.length)
                index++;
//                a_i += probabilities[index];
            }

            selectedParents[i] = population[index];
        }

        return selectedParents;
    }
}
