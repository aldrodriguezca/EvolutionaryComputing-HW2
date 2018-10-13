package Problems;

public class Rastrigin extends  Function{

    public Rastrigin(){
        this.xMax = 5.12;
        this.xMin = -5.12;
    }

    @Override
    public double evaluate(double[] x) {
        double val = 0;

        //sum x_i ** 2 - (cos(2*pi*x_i))
        for(Double x_i: x)
            val += x_i * x_i - (10*Math.cos(2*Math.PI*x_i));

        val += 10*x.length; //10d
        return val;
    }
}
