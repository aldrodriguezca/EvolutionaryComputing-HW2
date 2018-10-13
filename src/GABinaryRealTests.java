import GA.GA;
import GeneralComponents.*;
import Problems.*;

public class GABinaryRealTests {
    public static void main(String[] args) {
        double xMax = 5.12;
        double xMin = -5.12;
        int precisionDigits = 1;
        double[] x = new double[]{-0.8,4, 3, 2, -2, 6, 4, 3.7};

        BinaryRealRepresentation binaryRealRepresentation = new BinaryRealRepresentation(xMin, xMax, precisionDigits, x.length);
        binaryRealRepresentation.setRepresentation( BinaryRealRepresentation.realToIntRepresentation(x, precisionDigits, xMax) );
        System.out.println(binaryRealRepresentation.showRepresentation());
        double[] xT = binaryRealRepresentation.mapToReal();

        for (Double x_i: xT){
            System.out.println(x_i);
        }

        MutationStrategy mutation = new BinaryRealMutation();
        Individual mutated = mutation.mutate(binaryRealRepresentation);

        BinaryRealRepresentation mi = (BinaryRealRepresentation) mutated;
        System.out.println(mi.showRepresentation());

        //Problem configuration
        //------------------
        Function rastrigin = new Rastrigin();
        Function griewank = new Griewank();
        Function schwefel = new Schwefel();
        Function  rosenbrock = new Rosenbrock(); //Take care, just 2 dimensions
        //------------------
        int popSize = 100;
        int nIterations = 800;
        int nDims = 2;
        RecombinationStrategy recombination = new BinaryRealRecombination(popSize);
        SelectionStrategy selection = new Elitism((int)(0.10 * popSize), true);
        selection = new RouletteWheelSelection((int)(0.10 * popSize));
        ReplacementStrategy replacement = new GenerationalSurvivorSelection();

        //------------------

        //BinaryRealRepresentation[] population = BinaryRealRepresentation.getRandomPopulation(100, rastrigin.getxMin(), rastrigin.getxMax(), 4, nDims);
        BinaryRealRepresentation[] population = BinaryRealRepresentation.getRandomPopulation(100, griewank.getxMin(), griewank.getxMax(), 3, nDims);
        //BinaryRealRepresentation[] population = BinaryRealRepresentation.getRandomPopulation(100, schwefel.getxMin(), schwefel.getxMax(), 3, nDims);
        //BinaryRealRepresentation[] population = BinaryRealRepresentation.getRandomPopulation(100, rosenbrock.getxMin(), rosenbrock.getxMax(), 3, 2);

        System.out.println("INITIAL POP");
        for(BinaryRealRepresentation i: population){
            System.out.print(i.showRepresentation());
            //System.out.println(" f: " + i.evaluateFitness(rastrigin));
            System.out.println(" f: " + i.evaluateFitness(griewank));
            //System.out.println(" f: " + i.evaluateFitness(schwefel));
            //System.out.println(" f: " + i.evaluateFitness(rosenbrock));
        }
        //GA geneticAlgorithm = new GA(population, rastrigin, mutation, recombination, selection, replacement);
        GA geneticAlgorithm = new GA(population, griewank, mutation, recombination, selection, replacement, true);
        //GA geneticAlgorithm = new GA(population, schwefel, mutation, recombination, selection, replacement);
        //GA geneticAlgorithm = new GA(population, rosenbrock, mutation, recombination, selection, replacement);

        Individual[] solutions = geneticAlgorithm.evolve(nIterations).getSolutions();

        for(Individual s: solutions){
            System.out.print(s.showRepresentation());
            //System.out.println(" f: " + s.evaluateFitness(rastrigin));
            System.out.println(" f: " + s.evaluateFitness(griewank));
            //System.out.println(" f: " + s.evaluateFitness(schwefel));
           // System.out.println(" f: " + s.evaluateFitness(rosenbrock));
            System.out.println(showRealRepresentation((BinaryRealRepresentation) s));
        }




    }

    public static String showRealRepresentation(BinaryRealRepresentation individual){
        StringBuilder sb = new StringBuilder();

        double[] realRepresentation = individual.mapToReal();

        sb.append("[");
        for(int i = 0; i < realRepresentation.length; i++)
            sb.append( realRepresentation[i]  + (i != realRepresentation.length -1 ? ", ": " ]") );


        return sb.toString();
    }
}
