package GeneralComponents;

import Utils.GaussianRandomGenerator;
import Utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class ESRecombinationStrategy extends RecombinationStrategy {


    RandomGenerator randomGenerator;

    public ESRecombinationStrategy(){
        this.randomGenerator = new GaussianRandomGenerator();
    }

    @Override
    public Individual[] mixParents(Individual[] parents) {
        RealIndividual[] realParents = new RealIndividual[parents.length];
        RealIndividual[] child = new RealIndividual[0];

        boolean multipleSigmas = false;

        for(int i = 0; i < parents.length; i++)
            realParents[i] = (RealIndividual) parents[i];

        if(realParents[0].getIndependentSigma()){
            multipleSigmas = true;
        }

        if(!multipleSigmas){
            //TODO: check

        }else{
            double[] representation = new double[realParents[0].getRepresentation().length];
            int sigmas = realParents[0].getIndependentSigmas().length;
            double[] alphasTotals = new double[sigmas];

            for(int i = 0; i < alphasTotals.length; i++)
                alphasTotals[i] = 0;

            List<double[]> alphas = new ArrayList<>(parents.length);

            for(int i = 0; i  < parents.length; i++){
                double[] alphasArray = new double[sigmas];

                for(int j = 0; j < sigmas; j++) {
                    double alpha_j = randomGenerator.generate();
                    alphasArray[j] = alpha_j;
                    alphasTotals[j] += alpha_j;
                }
                alphas.add(alphasArray);
            }

            //normalize
            for(int i = 0; i < alphas.size(); i++){
                double[] alpha_star = alphas.get(i);
                for(int j = 0; j < alpha_star.length; i++){
                    alpha_star[j] = alpha_star[j]/alphasTotals[j];
                }

                alphas.set(i, alpha_star);
            }

            for(int i = 0 ; i < representation.length; i++){
                double alpha_p_j = 0;
                for(int j = 0; j < alphas.size(); j++){
                    alpha_p_j += alphas.get(j)[i]*realParents[j].getRepresentation()[i];
                }
                representation[i] = alpha_p_j;
            }
        }
        return child;
    }

    @Override
    public Individual[] recombineParents(Individual[] parents) {
        return new Individual[0];
    }
}
