public class Individual<T> implements Comparable<Individual>{

    T representation;

    public Individual(T representation){
        this.representation = representation;
    }

    public double evaluateFitness(){
        return 0;
    }


    @Override
    public int compareTo(Individual o) {
        return (int)(this.evaluateFitness() - evaluateFitness());
    }
}
