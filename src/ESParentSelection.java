public class ESParentSelection extends SelectionStrategy{

    private int k;

    public ESParentSelection(){

    }

    @Override
    Individual[] selectParents(Individual[] population) {
        Individual[] selectedParents = new Individual[k];

        for(int i = 0; i < k ; i ++)
            selectedParents[i] =   population[(int)Math.random()*population.length];

        return selectedParents;

    }
}
