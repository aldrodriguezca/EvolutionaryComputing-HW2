package GeneralComponents;

import Problems.Function;

public abstract class Individual<T>{

    T representation;

    public Individual(){
    //    this.f = f;
    }
    /*public GeneralComponents.Individual(T representation){
        this.representation = representation;
    }*/

    public double evaluateFitness(Function f){
        return f.evaluate( mapToReal());
    }

    public abstract double[] mapToReal();

    public abstract String showRepresentation();

    public T getRepresentation() {
        return representation;
    }
}
