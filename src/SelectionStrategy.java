public abstract class SelectionStrategy {
    protected int qParentsToSelect;
    //Parents
    abstract Individual[] selectParents(Individual[] population);
}
