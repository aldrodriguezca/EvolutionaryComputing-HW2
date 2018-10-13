package Utils;

import java.util.Random;

/**
 * Created by alvaro on 3/09/18.
 */
public class GaussianRandomGenerator extends RandomGenerator{

    public GaussianRandomGenerator(){
        this.random = new Random();
    }


    public double generate() {
        return random.nextGaussian();
    }
    //Utils class --> used to generate numbers under certain pdf ex: power law
}
