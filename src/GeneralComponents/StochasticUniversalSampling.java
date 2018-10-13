package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.SelectionStrategy;
import Problems.Function;

public class StochasticUniversalSampling  extends SelectionStrategy {

    private double[] fitnessEvaluations;

    public StochasticUniversalSampling(int qParentsToSelect){
        this.qParentsToSelect = qParentsToSelect;
    }


    public void evaluateFitness(Individual[] population, Function f){
        fitnessEvaluations = new double[population.length];

        double totalFitness = 0;

        double f_i;

        for(int i = 0; i < population.length; i++){
            f_i = population[i].evaluateFitness(f);
            fitnessEvaluations[i] = f_i;
            totalFitness += f_i;
        }

        //normalize
        for(int i = 0; i < fitnessEvaluations.length; i++)
            fitnessEvaluations[i] /= totalFitness;
    }
    @Override
    public Individual[] selectParents(Individual[] population, Function f) {
        Individual[] parents = new Individual[qParentsToSelect];

        evaluateFitness(population, f);


        double nPointer = 1.0/qParentsToSelect;
        double r = Math.random()*nPointer;

        for(int i = 0; i < qParentsToSelect; i++){
            double a_i = 0;
            int index = 0;

            //TODO: Check if sorting is necessary
            while (r < a_i){
                a_i += fitnessEvaluations[i];
                r = r+nPointer;
                index++;
            }

            parents[i] = population[index];
        }

        return parents;
    }
}
