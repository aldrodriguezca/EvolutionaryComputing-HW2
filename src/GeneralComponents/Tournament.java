package GeneralComponents;

import GeneralComponents.Individual;
import GeneralComponents.SelectionStrategy;
import Problems.Function;

import java.util.Arrays;
import java.util.Comparator;

public class Tournament extends SelectionStrategy {
    private int tournamentSize;

    public Tournament(int tournamentSize, int qParentsToSelect){
        this.tournamentSize = tournamentSize;
        this.qParentsToSelect = qParentsToSelect;
    }

    private Individual performTournament(Individual[] population, Function function){
        Individual []contenders = new Individual[tournamentSize];

        for(int i = 0; i < tournamentSize; i++)
            contenders[i] = population[(int)Math.random()*population.length];

        Arrays.sort(contenders, new Comparator<Individual>() {
            @Override
            public int compare(Individual o1, Individual o2) {
                double diff = o2.evaluateFitness(function) - o1.evaluateFitness(function);
                return  diff > 0? 1: diff < 0? -1: 0;
            }
        });
        return contenders[0];
    }

    @Override
    public Individual[] selectParents(Individual[] population, Function function) {
        Individual [] selectedParents = new Individual[qParentsToSelect];

        for(int i = 0; i < qParentsToSelect; i++)
            selectedParents[i] = performTournament(population, function);

        return selectedParents;
    }
}
