import java.util.Arrays;
import java.util.Collections;

public class RankingSelection extends SelectionStrategy {

    private double[] probabilities;
    private double S;


    public RankingSelection(int qParentsToSelect){
        this.qParentsToSelect = qParentsToSelect;
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
    Individual[] selectParents(Individual[] population) {
        Individual[] selectedParents = new Individual[qParentsToSelect];
        //TODO: Check
        Arrays.sort(population, Collections.reverseOrder());
        computeProbabilities(population);

        double r, a_i;
        int index;
        for(int i = 0; i < qParentsToSelect; i++){
            r = Math.random();

            index = 0;
            a_i = 0;
            do{
                a_i += probabilities[index];
                index++;
            }while(a_i < r);

            selectedParents[i] = population[index];
        }

        return selectedParents;
    }
}
