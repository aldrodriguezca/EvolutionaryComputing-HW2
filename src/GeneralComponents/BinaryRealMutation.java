package GeneralComponents;

public class BinaryRealMutation extends MutationStrategy {


    public BinaryRealMutation(){
        this.mutationRate = 0.6;
    }

    @Override
    public Individual mutate(Individual individual) {
        BinaryRealRepresentation brIndividual = (BinaryRealRepresentation) individual;

        double mutationRate = 1.0 / brIndividual.getRepresentation().length;

        int[] representation = brIndividual.getRepresentation().clone();

        for(int i = 0; i < representation.length; i++){
            if(Math.random() > (1-mutationRate)){
                String binaryRepresentation = Integer.toBinaryString(representation[i]);
                int index = (int)(Math.random() * binaryRepresentation.length());
                int power = binaryRepresentation.length() - index - 1;
                int number = (int)Math.pow(2, power);
                representation[i] = representation[i] ^ number;
            }
        }

        return new BinaryRealRepresentation(representation);

    }
}
