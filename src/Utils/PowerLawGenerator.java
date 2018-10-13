package Utils;

import java.util.Random;

/**
 * Created by alvaro on 10/09/18.
 */
public class PowerLawGenerator extends RandomGenerator{
    private double alpha = 2.0;

    public PowerLawGenerator(double alpha){
        this.random = new Random();
        this.alpha = alpha;
    }

    //Assuming x is generated from a normal distribution
    public double generate() {
        double x = random.nextGaussian();
        int direction = Math.random() >= 0.5 ? 1:-1;
        double coarseAlpha = 1.0/(1.0-alpha);
        return direction*Math.pow( 1.0 -x,  coarseAlpha);
    }

}
