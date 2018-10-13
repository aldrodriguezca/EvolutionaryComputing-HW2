package GeneralComponents;

import Utils.GaussianRandomGenerator;
import Utils.RandomGenerator;

import java.util.Random;

public class RealMutation extends MutationStrategy {

    //Parameter for modify sigmas
    private double tau;
    private RandomGenerator r;

    public RealMutation(double tau){
        this.tau = tau;
        r = new GaussianRandomGenerator();
    }

    @Override
    public Individual mutate(Individual individual) {

        RealIndividual realIndividual = (RealIndividual) individual;

        double[] representation = realIndividual.getRepresentation().clone();
        if(!realIndividual.getIndependentSigma()){
            double sigma = realIndividual.getSigma();
            double exp, aux;
            do{
                exp = r.generate()*tau;
                aux = Math.exp(exp);
            }while(aux == 0);

            sigma *= aux;

            for(int i = 0; i < representation.length; i++)
                representation[i] += r.generate()*sigma;
        }
        else{
            double[] sigmas = realIndividual.getIndependentSigmas().clone();

            //TODO: Add correlated mutation (with covariance matrix)
            //modify each sigma
            double exp, aux;
            for(int i = 0; i < sigmas.length; i++){
                do{
                    exp = r.generate()*tau;
                    aux = Math.exp(exp);
                }while (aux == 0);

                sigmas[i] *= aux;
            }
            //modify each dimension using respective sigma
            for(int i = 0; i < representation.length; i++){
                representation[i] += r.generate()*sigmas[i];
            }
        }
        //TODO:
        return new RealIndividual(representation);
    }
}
