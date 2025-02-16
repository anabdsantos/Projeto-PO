package hva.habitat.tree;

public class PerFallState extends TreeCycleState{
    public PerFallState (Tree tree) {
		super(tree, "COMFOLHAS", 1);
	}

    @Override
    public void next(){
        getTree().setState(new PerWinterState(getTree()));
    }
}
