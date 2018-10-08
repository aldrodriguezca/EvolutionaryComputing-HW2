import java.lang.reflect.Array;
import java.util.Arrays;

public class Tournament extends SelectionStrategy {

    private int tournamentSize;
    private int qSelectedParents;

    public Tournament(int tournamentSize, int qSelectedParents){
        this.tournamentSize = tournamentSize;
        this.qSelectedParents = qSelectedParents;
    }

    private Individual performTournament(Individual[] population){
        Individual []contenders = new Individual[tournamentSize];

        for(int i = 0; i < tournamentSize; i++)
            contenders[i] = population[(int)Math.random()*population.length];

        Arrays.sort(contenders);
        return contenders[0];
    }

    @Override
    Individual[] selectParents(Individual[] population) {
        Individual [] selectedParents = new Individual[qSelectedParents];

        for(int i = 0; i < qSelectedParents; i++)
            selectedParents[i] = performTournament(population);

        return selectedParents;
    }
}
