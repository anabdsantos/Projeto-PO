package hva.habitat.tree;

public abstract class TreeCycleState {
    private Tree _tree;
    private String _cycle;
    private int _seasonalEffort;

    public TreeCycleState(Tree tree, String cycle, int 
    seasonalEffort){
        _tree = tree;
        _cycle = cycle;
        _seasonalEffort = seasonalEffort;
    }

    public Tree getTree(){
        return _tree;
    }

    public int getSeasonalEffort(){
        return _seasonalEffort;
    }

    public String getCycle(){
        return _cycle;
    }

    public abstract void next();
}
