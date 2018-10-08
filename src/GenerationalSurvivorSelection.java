public class GenerationalSurvivorSelection extends ReplacementStrategy {
    @Override
    Individual[] selectSurvivals(Individual[] parents, Individual[] offspring) {
        return offspring;
    }
}
