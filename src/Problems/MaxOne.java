package Problems;

import GeneralComponents.*;

public class MaxOne extends Function {

    private int stringLength;

    public MaxOne(int stringLength){
        this.stringLength = stringLength;
    }

    public int getStringLength() {
        return stringLength;
    }

    MaxOneIndividual generateRandomIndividual(){
        boolean [] representation = new boolean[stringLength];
        for(int i = 0; i < stringLength; i++){
            representation[i] = Math.random() < 0.5? true: false;
        }

        return new MaxOneIndividual(representation);
    }

    //In this particular each x_i correspond to a bit
    public MaxOneIndividual[] initPopulation(int popSize){
        MaxOneIndividual[] initPopulation = new MaxOneIndividual[popSize];

        for(int i = 0; i < popSize; i++)
            initPopulation[i] = generateRandomIndividual();


        return initPopulation;
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0;

        for(Double x_i: x)
            fitness += x_i == 1.0? 1 : 0;


        return fitness / x.length;
    }
}
