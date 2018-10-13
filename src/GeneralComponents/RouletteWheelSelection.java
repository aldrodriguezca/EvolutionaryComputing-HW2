package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.SelectionStrategy;
import Problems.Function;

import java.util.Arrays;
import java.util.Comparator;

public class RouletteWheelSelection extends SelectionStrategy {
    private double[] fitnessEvaluations;

    public RouletteWheelSelection(int qParentsToSelect){
        this.qParentsToSelect = qParentsToSelect;
    }

    public void evaluateFitness(Individual[] population, Function function){
        double totalFitness = 0;

        fitnessEvaluations = new double[population.length];

        double f_i;
        for(int i = 0; i < population.length; i++){
            f_i = population[i].evaluateFitness(function);
            fitnessEvaluations[i] = f_i;
            totalFitness += f_i;
        }

        //Normalize
        for(int j = 0; j < fitnessEvaluations.length; j++)
            fitnessEvaluations[j] = fitnessEvaluations[j]/totalFitness;

       // Arrays.sort(fitnessEvaluations);
    }

    @Override
    public Individual[] selectParents(Individual[] population, Function function) {

        Individual[] parents = new Individual[qParentsToSelect];
        Arrays.sort(population, new Comparator<Individual>() {
            @Override
            public int compare(Individual o1, Individual o2) {
                double diff = o2.evaluateFitness(function) - o1.evaluateFitness(function);
                return  diff > 0? 1: diff < 0? -1: 0;
            }
        });

        evaluateFitness(population, function);

        double r;
        int index;

        //TODO: Check
        for(int i = 0; i < qParentsToSelect; i++){
            r = Math.random();
            double a_i = 0;
            a_i += fitnessEvaluations[0];

            index = 0;

            while (a_i < r) {

                a_i += fitnessEvaluations[index];
                index++;
            }
            parents[i] = population[index];
        }
        return parents;
    }
}
