package Problems;

public class Schwefel extends Function {

    public Schwefel(){
        this.xMin = -500;
        this.xMax = 500;
    }

    @Override
    public double evaluate(double[] x) {
        double sum = 0;

        for(Double x_i:x){
            sum += x_i *  Math.sin( Math.sqrt(  Math.abs( x_i )  ) );
        }
        return 418.9829 * x.length - sum;
    }
}
