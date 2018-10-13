import DataUtils.DataOutput;
import GA.GA;
import GeneralComponents.*;
import Problems.Deceptive4;
import Problems.MaxOne;
import Problems.MaxOneIndividual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GATests {
    public static void main(String[] args) {

        //Problems settings
        //---------------------------------------------------
        int stringLength = 16;
        MaxOne maxOneProblem  = new MaxOne(stringLength);
        int popSize = 200;

        double mutationRate = 1.0 / stringLength;
        MaxOneIndividual[] population = maxOneProblem.initPopulation(popSize);

        //---------------------------------------------------

        int deceptiveLength = 40;
        Deceptive4 deceptive4 = new Deceptive4(deceptiveLength);
        mutationRate = 1.0 / deceptiveLength;

        BinaryRepresentation[] binaryPopulation = new BinaryRepresentation[popSize];
        binaryPopulation = BinaryRepresentation.generateRandomPopulation(popSize, deceptiveLength);

        //---------------------------------------------------

        // GA's mechanisms settings
        //---------------------------------------------------
        MutationStrategy mutation = new BinaryMutation( mutationRate );
        RecombinationStrategy recombination = new BinaryRecombination(popSize);
        SelectionStrategy selection = new Elitism((int)(0.1*popSize), false);
        //selection = new Tournament(10, (int)(0.1*popSize));
        //selection = new RouletteWheelSelection((int)(0.1*popSize));
        //selection = new RankingSelection((int)(0.1*popSize));
        ReplacementStrategy replacement = new GenerationalSurvivorSelection();
        //replacement = new SteadyStateFitnessSurvivorSelection(popSize, popSize );
        //---------------------------------------------------

        //---------------------------------------------------
        //GA geneticAlgorithm = new GA(population, maxOneProblem, mutation, recombination, selection, replacement);
        //---------------------------------------------------

        //Individual[] solutions = geneticAlgorithm.evolve(100);

        //-----------------------------------------------------------
        /*MaxOneIndividual maxOneIndividual;
        for(int i = 0; i < solutions.length; i++){
            maxOneIndividual = (MaxOneIndividual) solutions[i];
            System.out.print(maxOneIndividual.showRepresentation());
            System.out.println(" f: " + maxOneIndividual.evaluateFitness(maxOneProblem) );
        }*/

        //-------------------------------------------------------------
        int nIterations = 150;
        GA geneticAlgorithm = new GA(binaryPopulation, deceptive4, mutation, recombination, selection, replacement, false);

        Individual[] solutions = geneticAlgorithm.evolve(nIterations).getSolutions();
        //-------------------------------------------------------------
        /*
        for(Individual s: solutions){
            System.out.print(s.showRepresentation());
            System.out.println(" f: " + s.evaluateFitness(deceptive4));
        }*/


        HashMap<String, HashMap<String, List<double[]>>> results = new HashMap<>();
        List<double[]> localResults;
        HashMap<String, List<double []>> methodsResults = new HashMap<>();

        int nExperiments = 100;

        localResults = new ArrayList<>(nExperiments);

        for(int i = 0; i < nExperiments; i++){
            localResults.add( geneticAlgorithm.evolve(nIterations).getFitnessHistory());
        }

        methodsResults.put("ga_elitism", localResults);

        results.put("Deceptive4" , methodsResults);

        DataOutput.outputData(results);
    }
}
