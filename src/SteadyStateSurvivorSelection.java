public class SteadyStateSurvivorSelection extends ReplacementStrategy{

    public Individual[] mergePopulation(){
        return new Individual[0];
    }

    @Override
    Individual[] selectSurvivals(Individual[] parents, Individual[] offspring) {
        return mergePopulation();
    }
}
