package GeneralComponents;

public class BinaryRecombination extends RecombinationStrategy {

    public BinaryRecombination(int lambda){
        this.lambda = lambda;
    }

    private Individual[] mix(BinaryRepresentation p1, BinaryRepresentation p2 , int cp){
        Individual[] offspring = new BinaryRepresentation[2];

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

        offspring[0] = new BinaryRepresentation(r1);
        offspring[1] = new BinaryRepresentation(r2);

        return offspring;
    }

    @Override
    public Individual[] mixParents(Individual[] parents) {
        BinaryRepresentation p1 = (BinaryRepresentation)parents[0];
        BinaryRepresentation p2 = (BinaryRepresentation)parents[1];

        int cp =(int) (Math.random()* p1.getRepresentation().length); //X over point
        return mix(p1, p2, cp);
    }
}
