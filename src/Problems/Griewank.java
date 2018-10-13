package Problems;

public class Griewank extends Function {

    public Griewank(){
        this.xMax = 600;
        this.xMin = -600;
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0;
        double product = 1;

        for(Double x_i: x)
            sum += ((x_i*x_i)/(4000));


        for(int i = 1; i <= x.length; i++)
            product *= Math.cos(x[i-1]/Math.sqrt(i));

        return sum - product + 1;
    }
}
