package GeneralComponents;

public class BinaryRealRecombination extends RecombinationStrategy{


    public BinaryRealRecombination(int lambda){
        this.lambda = lambda;
    }

    public Individual[] mix(BinaryRealRepresentation p1, BinaryRealRepresentation p2, int cp){
        Individual[] offspring = new BinaryRealRepresentation[2];

        int[] r1 = p1.getRepresentation().clone();
        int[] r2 = p2.getRepresentation().clone();

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

        offspring[0] = new BinaryRealRepresentation(r1);
        offspring[1] = new BinaryRealRepresentation(r2);

        return offspring;
    }

    @Override
    public Individual[] mixParents(Individual[] parents) {
        BinaryRealRepresentation p1 = (BinaryRealRepresentation)parents[0];
        BinaryRealRepresentation p2 = (BinaryRealRepresentation)parents[1];

        int cp =(int) (Math.random()* p1.getRepresentation().length); //X over point
        return mix(p1,p2, cp);
    }
}
