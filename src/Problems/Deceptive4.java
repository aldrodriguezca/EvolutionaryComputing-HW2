package Problems;

public class Deceptive4 extends Function{

    private int length;

    public Deceptive4(int length){
        this.length = length;
    }

    @Override
    public double evaluate(double[] x) {
        int nOnes = 0;

        for(Double x_i : x){
            if(x_i == 1)
                nOnes++;
        }

        if(nOnes == 0) return x.length;
        else return nOnes;
    }
}
