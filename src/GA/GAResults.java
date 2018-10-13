package GA;

import GeneralComponents.Individual;

public class GAResults {
    private Individual[] solutions;
    private double[] fitnessHistory;

    public GAResults(Individual[] solutions, double[] fitnessHistory){
        this.solutions = solutions;
        this.fitnessHistory = fitnessHistory;
    }
    public Individual[] getSolutions() {
        return solutions;
    }

    public double[] getFitnessHistory() {
        return fitnessHistory;
    }




}
