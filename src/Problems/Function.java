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
}
