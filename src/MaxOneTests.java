import GA.GA;
import GeneralComponents.*;
import Problems.MaxOne;
import Problems.MaxOneIndividual;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.Comparator;

public class MaxOneTests {

    public static void main(String[] args) {
        int stringLength = 10;
        MaxOne maxOneProblem  = new MaxOne(stringLength);
        int popSize = 20;

        MaxOneIndividual[] population = maxOneProblem.initPopulation(popSize);

        MaxOneIndividual maxOneIndividual;
        for(int i = 0 ; i < popSize; i++){
            maxOneIndividual = population[i];
            System.out.print("[ ");
            boolean[] representation = maxOneIndividual.getRepresentation();
            System.out.print(maxOneIndividual.showRepresentation());
            System.out.println("  f:" + maxOneIndividual.evaluateFitness(maxOneProblem));
        }

        Arrays.sort(population, new Comparator<Individual>() {
            @Override
            public int compare(Individual o1, Individual o2) {
                double diff = o2.evaluateFitness(maxOneProblem) - o1.evaluateFitness(maxOneProblem);
                return  diff > 0? 1: diff < 0? -1: 0;
            }
        });

        System.out.println("SORTED population");
        for(int i = 0 ; i < popSize; i++){
            maxOneIndividual = population[i];
            System.out.print(maxOneIndividual.showRepresentation());
            System.out.println("  f:" + maxOneIndividual.evaluateFitness(maxOneProblem));
        }
/*

        System.out.println("MUTATED");


        System.out.println("mutation rate" + 1.0/maxOneProblem.getStringLength());

        MutationStrategy binaryMS = new MaxOneMutation(1.0/maxOneProblem.getStringLength());

        MaxOneIndividual mutated = (MaxOneIndividual) binaryMS.mutate(population[0]);

        System.out.println("original");

        MaxOneIndividual original = population[0];
        System.out.println(original.showRepresentation());
        System.out.println("  f:" + population[0].evaluateFitness(maxOneProblem));


        for(int k = 0; k < stringLength; k++){
            mutated = (MaxOneIndividual) binaryMS.mutate(population[0]);
            System.out.print(mutated.showRepresentation());
            System.out.println("  f:" + mutated.evaluateFitness(maxOneProblem));
            System.out.println(original.showRepresentation());
        }

        System.out.println("test recombination");
        RecombinationStrategy binaryRecombination = new MaxOneRecombination();

        MaxOneIndividual[] parents = new MaxOneIndividual[2];

        MaxOneIndividual p1 = population[0];
        MaxOneIndividual p2 = population[1];


        parents[0] = p1;
        parents[1] = p2;

        System.out.println("Padres: ");

        System.out.println(p1.showRepresentation());
        System.out.println(p2.showRepresentation());

        MaxOneIndividual[] sons = (MaxOneIndividual[]) binaryRecombination.mixParents(parents);
        MaxOneIndividual s1 = sons[0];
        MaxOneIndividual s2 = sons[1];

        System.out.println("HIJOS:");
        System.out.println(s1.showRepresentation());
        System.out.println(s2.showRepresentation());*/

        SelectionStrategy selection = new Tournament(6, 5);

        Individual[] parents =  selection.selectParents(population, maxOneProblem);

        MaxOneIndividual s = (MaxOneIndividual) parents[0];
        System.out.println(s.showRepresentation());

        System.out.println("Selected parents"+  parents.length);

        selection = new Elitism( 5, false);

        parents =  selection.selectParents(population, maxOneProblem);

        System.out.println("Selected by elitism");
        for(int i =0; i< parents.length; i++){
            maxOneIndividual = (MaxOneIndividual) parents[i];
            System.out.print(maxOneIndividual.showRepresentation());

            System.out.println(" f: " + maxOneIndividual.evaluateFitness(maxOneProblem));
        }


    }
}
