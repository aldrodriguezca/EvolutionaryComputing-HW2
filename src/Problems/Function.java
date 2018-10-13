package Problems;

public abstract class Function {
    protected double xMax, xMin;
    public abstract double evaluate(double x []);

    public double getxMax() {
        return xMax;
    }

    public double getxMin() {
        return xMin;
    }

    public boolean isFeasible(double x){
        return x > xMin && x < xMax;
    }

    public boolean isFeasibleVector(double[] x){
        for (Double x_i: x) {
            if(x_i < xMin || x_i > xMax)
                return false;
        }
        return true;
    }
}
