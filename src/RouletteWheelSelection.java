import java.util.ArrayList;
import java.util.List;

public class RouletteWheelSelection extends SelectionStrategy {
    private double[] fitnessEvaluations;

    public RouletteWheelSelection(int qParentsToSelect){
        this.qParentsToSelect = qParentsToSelect;
    }

    public void evaluateFitness(Individual[] population){
        double totalFitness = 0;

        fitnessEvaluations = new double[population.length];

        double f_i;
        for(int i = 0; i < population.length; i++){
            f_i = population[i].evaluateFitness();
            fitnessEvaluations[i] = f_i;
            totalFitness += f_i;
        }

        //Normalize
        for(int j = 0; j < fitnessEvaluations.length; j++)
            fitnessEvaluations[j] = fitnessEvaluations[j]/totalFitness;

    }

    @Override
    Individual[] selectParents(Individual[] population) {

        Individual[] parents = new Individual[qParentsToSelect];

        evaluateFitness(population);

        double r;
        int index;

        for(int i = 0; i < qParentsToSelect; i++){
            r = Math.random();
            double a_i = 0;
            index = 0;

            do{
                a_i += fitnessEvaluations[index];
                index++;
            }while (a_i < r);

            parents[i] = population[index];
        }
        return parents;
    }
}
