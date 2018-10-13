package GeneralComponents;

public class BinaryMutation extends MutationStrategy{

    private double mutationRate;

    public BinaryMutation(double mutationRate){
        this.mutationRate = mutationRate;
    }

    @Override
    public Individual mutate(Individual individual) {
        BinaryRepresentation binaryRepresentation = (BinaryRepresentation) individual;

        boolean[] representation = binaryRepresentation.getRepresentation().clone();
        for(int i = 0; i < binaryRepresentation.getRepresentation().length; i++){
            double r = Math.random();
            if(r >= (1-mutationRate) )
                representation[i] = !representation[i];

        }

        return new BinaryRepresentation(representation);
    }
}
