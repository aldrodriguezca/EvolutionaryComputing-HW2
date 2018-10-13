package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.ReplacementStrategy;
import Problems.Function;

public class GenerationalSurvivorSelection extends ReplacementStrategy {


    @Override
    public Individual[] selectSurvivals(Individual[] parents, Individual[] offspring, Function function) {
        return offspring;
    }
}
