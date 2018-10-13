package GeneralComponents;

public abstract class RecombinationStrategy {

    protected int lambda; //number of children

    public abstract Individual[] mixParents(Individual[] parents);

    public Individual[] recombineParents(Individual[] parents) {

        Individual[] offspring = new Individual[lambda];

        for(int i = 0; i < lambda-1; i++){
            Individual[] toMix = new Individual[2];
            int ip1 = (int)Math.random()*parents.length, ip2 = (int)Math.random()*parents.length;
            toMix[0] = parents[ip1];
            toMix[1] = parents[ip2];
            Individual[] mixed = mixParents(toMix);

            offspring[i] = mixed[0];
            offspring[i+1] = mixed[1];
        }

        return offspring;
    }

}
