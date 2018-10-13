package GeneralComponents;

import Problems.MaxOne;
import Problems.MaxOneIndividual;

public class MaxOneMutation extends MutationStrategy{

    private double mutationRate;

    public MaxOneMutation(double mutationRate){
        this.mutationRate = mutationRate;
    }

    @Override
    public Individual mutate(Individual individual) {
        MaxOneIndividual moi = (MaxOneIndividual)individual;

        boolean[] representation = moi.getRepresentation().clone();
        for(int i = 0; i < moi.getRepresentation().length; i++){
            double r = Math.random();
            if(r >= (1-mutationRate) )
                representation[i] = !representation[i];


        }

        return new MaxOneIndividual(representation);
    }
}
