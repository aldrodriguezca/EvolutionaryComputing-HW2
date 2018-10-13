package Problems;

import GeneralComponents.Individual;

public class MaxOneIndividual extends Individual {

    private int length;
    private boolean[] representation;

    public boolean[] getRepresentation() {
        return representation;
    }

    public MaxOneIndividual(int length){
        super();
        this.length = length;
        this.representation = new boolean[length];
    }

    public MaxOneIndividual(boolean[] representation){
        super();
        this.representation = representation;
        this.length = representation.length;
    }


    public void setRepresentation(boolean[] representation){
        this.representation = representation;
    }



    @Override
    public double[] mapToReal() {
        double [] realRepresentation = new double[length];
        for(int i = 0; i < length; i++)
            realRepresentation[i] = representation[i]? 1: 0;

        return realRepresentation;
    }

    public String showRepresentation(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i = 0; i < representation.length; i++ )
            sb.append( (representation[i]? "1": "0") + ( i == representation.length - 1? "] " : ", ") );

        return sb.toString();
    }
}
