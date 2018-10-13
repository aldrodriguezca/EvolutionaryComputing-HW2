package GeneralComponents;

import Problems.MaxOne;
import Problems.MaxOneIndividual;

public class MaxOneRecombination extends RecombinationStrategy{

    public MaxOneRecombination(int lambda){
        this.lambda = lambda;
    }

    private Individual[] mix(MaxOneIndividual p1, MaxOneIndividual p2 , int cp){
        Individual[] offspring = new MaxOneIndividual[2];

        boolean[] r1 = new boolean[p1.getRepresentation().length];
        boolean[] r2 = new boolean[p1.getRepresentation().length];

        for(int i = 0; i < p1.getRepresentation().length; i++){
            if(i <= cp){
                r1[i] = p1.getRepresentation()[i];
                r2[i] = p2.getRepresentation()[i];
            }
            else{
                r1[i] = p2.getRepresentation()[i];
                r2[i] = p1.getRepresentation()[i];
            }
        }

        offspring[0] = new MaxOneIndividual(r1);
        offspring[1] = new MaxOneIndividual(r2);

        return offspring;
    }

    @Override
    public Individual[] mixParents(Individual[] parents) {
        MaxOneIndividual p1 = (MaxOneIndividual)parents[0];
        MaxOneIndividual p2 = (MaxOneIndividual)parents[1];

        int cp =(int) (Math.random()* p1.getRepresentation().length); //X over point
        return mix(p1, p2, cp);
    }
}
