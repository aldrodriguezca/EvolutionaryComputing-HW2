package GeneralComponents;

import Problems.Function;

public abstract class ReplacementStrategy {

    private String type;

    public String getType(){
        return type;
    }
    //protected int
    public  abstract Individual[] selectSurvivals(Individual[] parents, Individual[] offspring, Function function);
}
