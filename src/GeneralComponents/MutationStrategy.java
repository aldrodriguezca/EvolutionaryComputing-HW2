package GeneralComponents;

public abstract class MutationStrategy<T> {
    protected double mutationRate;

    public abstract Individual mutate(Individual individual);
    public Individual[] mutate(Individual[] individuals){
        Individual[] mutated = individuals.clone();
        for(int i = 0; i < individuals.length; i++){
            mutated[i] = mutate(individuals[i]);
        }
        return mutated;
    }
}
