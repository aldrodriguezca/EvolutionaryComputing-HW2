package GeneralComponents;

import GeneralComponents.Individual;
import Problems.*;

public class RealIndividual extends Individual {

    private double sigma;
    private double[] independentSigmas;
    private boolean independentSigma;

    private double []representation;

    public RealIndividual(double[] representation){
        this.representation = representation;
    }

    public RealIndividual(double[] representation, double[] sigmas){
        this.representation = representation;
        this.independentSigmas = sigmas;
        this.independentSigma = true;
    }

    public RealIndividual(double[] representation, double sigma){
        this.representation = representation;
        this.sigma = sigma;
        this.independentSigma = false;
    }

    public double[] getRepresentation() {
        return representation;
    }

    public double getSigma() {
        return sigma;
    }


    public double[] getIndependentSigmas() {
        return independentSigmas;
    }

    public boolean getIndependentSigma() {
        return independentSigma;
    }

    public RealIndividual(int size, boolean independentSigma){
        super();
        //this.representation = new double[size];
        //TODO: check
        this.independentSigma = independentSigma;

        //if(independentSigmas) this.independentSigmas = new double[size];

        // this.representation = individualSigmas? new double[size*2] :new double[size+1];
    }


    @Override
    public double evaluateFitness(Function function) {
        //TODO
        return super.evaluateFitness(function);
    }

    @Override
    public double[] mapToReal() {
        return this.representation;
    }

    @Override
    public String showRepresentation() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i = 0; i < representation.length; i++ )
            sb.append( (representation[i]) + ( i == representation.length - 1? "] " : ", ") );

        return sb.toString();
    }


    public static double getRandomFromRange(double xMin, double xMax){
        double range = xMax - xMin;

        return Math.random() * range + xMin;

    }


    public static RealIndividual generateRandomIndividual(int nDims, double xMin, double xMax, boolean independentSigma, double initialSigma){
        double representation[] = new double[nDims];

        for(int i = 0; i < nDims; i++)
            representation[i] = getRandomFromRange(xMin, xMax);

        if(independentSigma){
            double[] sigmas = new double[nDims];

            double s_i;
            for(int i = 0; i < sigmas.length; i++){
                s_i = Math.random()*initialSigma;

                while(s_i == 0)
                    s_i = Math.random()*initialSigma;

                sigmas[i] = s_i;
            }
            return new RealIndividual(representation, sigmas);
        }

        return new RealIndividual(representation, initialSigma);
    }

    public static RealIndividual[] generateRandomPopulation(int popSize, int nDims, double xMin, double xMax, boolean independentSigma, double initialSigma ){

        RealIndividual[] population = new RealIndividual[popSize];
        for(int i = 0; i < popSize; i++)
            population[i] = generateRandomIndividual(nDims, xMin, xMax, independentSigma, initialSigma );

        return population;
    }
}
