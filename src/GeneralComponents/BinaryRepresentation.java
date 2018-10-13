package GeneralComponents;

import Problems.Function;

public class BinaryRepresentation extends Individual{

    boolean[] representation;


    public BinaryRepresentation(){
        super();
    }

    public BinaryRepresentation(boolean[] representation){
        this.representation = representation;
    }

    public static BinaryRepresentation generateRandomIndividual(int length){

        boolean[] representation = new boolean[length];
        for(int i = 0; i < length; i++)
            representation[i] = Math.random() < 0.5;


        return new BinaryRepresentation(representation);
    }

    public static BinaryRepresentation[] generateRandomPopulation(int popSize, int length){
        BinaryRepresentation[] population = new BinaryRepresentation[popSize];

        for(int i = 0; i < popSize; i++)
            population[i] = generateRandomIndividual(length);

        return population;
    }

    @Override
    public double[] mapToReal() {
        double[] real = new double[this.representation.length];

        for(int i = 0; i < this.representation.length; i++)
            real[i] = this.representation[i]? 1.0 : 0;

        return real;
    }

    @Override
    public String showRepresentation() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i = 0; i < representation.length; i++ )
            sb.append( (representation[i]? "1": "0") + ( i == representation.length - 1? "] " : ", ") );

        return sb.toString();
    }

    @Override
    public boolean[] getRepresentation() {
        return representation;
    }
}
