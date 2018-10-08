public class RealIndividual extends Individual {

    private double sigma;
    private double independentSigmas;
    private boolean independentSigma;

    public double getSigma() {
        return sigma;
    }

    public double getIndependentSigmas() {
        return independentSigmas;
    }

    public boolean isIndependentSigma() {
        return independentSigma;
    }

    public RealIndividual(int size, boolean independentSigmas){
        //this.representation = new double[size];
        //TODO: check
        this.independentSigma = independentSigmas;

        //if(independentSigmas) this.independentSigmas = new double[size];

        // this.representation = individualSigmas? new double[size*2] :new double[size+1];
    }

    @Override
    public double evaluateFitness() {
        return super.evaluateFitness();
    }
}
