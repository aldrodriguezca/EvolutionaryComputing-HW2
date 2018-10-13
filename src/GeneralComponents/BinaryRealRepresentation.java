package GeneralComponents;

import Problems.Function;

public class BinaryRealRepresentation extends Individual{

    private int[] representation;
    private static double xMax;
    private double xMin;
    private int precision;


    public BinaryRealRepresentation(double xMin, double xMax, int precision, int nDims){
        this.xMin = xMin;
        this.xMax = xMax;
        this.precision = precision;
        this.representation = new int[nDims];
    }

    public BinaryRealRepresentation(int[] representation){
        this.representation = representation;
    }

    public void setRepresentation(int [] representation){
        this.representation = representation;
    }

    public int[] getRepresentation(){
        return this.representation;
    }

    @Override
    public double[] mapToReal() {
        double[] realRepresentation = new double[representation.length];

        int tenPower = (int) Math.pow(10, precision);
        int maxValue = (int) (xMax*tenPower);

        int requiredBits = Integer.toBinaryString(maxValue).length();

        for(int i = 0; i < this.representation.length; i++){
            if(representation[i] > maxValue){ //negative
                realRepresentation[i] = -1*((double)representation[i] - (Math.pow(2, requiredBits))) / (double) ( tenPower );
            }else{
                realRepresentation[i] = ((double)representation[i])/(tenPower);
            }
        }

        return realRepresentation;
    }

    @Override
    public String showRepresentation() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");

        for(int i = 0; i < representation.length; i++){
            sb.append( representation[i] + ( i != representation.length - 1? ", ": " ]" ));
        }

        return sb.toString();
    }


    public static int[] realToIntRepresentation(double[] x, int precision, double xMax){
        int[] binaryIntRepresentation = new int[x.length];
        int tenPower = (int)Math.pow(10, precision);
        int upperLimit = (int)(xMax * tenPower);
        int requiredBits = Integer.toBinaryString(upperLimit).length();

        //System.out.println( "ten power " + tenPower + "  ul  " + upperLimit + " required bits " + requiredBits);
        for(int i = 0; i < x.length; i++){
            if(x[i] < 0)
                binaryIntRepresentation[i] = (int)( -1 * x[i]*tenPower) + (int)Math.pow(2, requiredBits);
            else
                binaryIntRepresentation[i] = (int) (tenPower*x[i]);
        }

        return binaryIntRepresentation;
    }

    public static BinaryRealRepresentation[] getRandomPopulation(int popSize, double xMin, double xMax, int precision, int nDims){
        BinaryRealRepresentation[] population = new BinaryRealRepresentation[popSize];

        for(int i = 0; i < popSize; i ++)
            population[i] = getRandomIndividual(xMax, xMin, precision, nDims);

        return population;
    }

    public static BinaryRealRepresentation getRandomIndividual(double xMax, double xMin, int precision, int nDims){
        double[] x = generateRandomDims(nDims, xMax, xMin);
        int[] intRepresentation = realToIntRepresentation(x, precision, xMax);
        return new BinaryRealRepresentation(intRepresentation);
    }


    public static double generateRadomInRange(double xMax, double xMin){
        double range = xMax - xMin;

        return range * Math.random() + xMin;
    }

    public static double[] generateRandomDims(int nDims, double xMax, double xMin){
        double[] randomVector = new double[nDims];

        for(int i = 0; i < nDims; i++)
            randomVector[i] = generateRadomInRange(xMax, xMin);

        return randomVector;
    }


}
