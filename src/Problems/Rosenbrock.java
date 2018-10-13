package Problems;

public class Rosenbrock extends Function {

    public Rosenbrock(){
        this.xMin = -2.048;
        this.xMax = 2.048;
    }

    @Override
    public double evaluate(double[] x) {
        return 100 * (Math.pow( ((x[0]*x[0])-x[1]) ,2 )) + Math.pow((1-x[0]), 2)//penalty
                +  (isFeasible(x[0])? 0: x[0]*x[0]*x[0]) + (isFeasible(x[1])? 0: x[1]*x[1]*x[1]);
    }
}
