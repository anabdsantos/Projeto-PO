package hva.habitat.tree;

public class PerWinterState extends TreeCycleState{
    public PerWinterState (Tree tree) {
		super(tree, "LARGARFOLHAS", 2);
	}

    @Override
    public void next(){
        getTree().setState(new PerSpringState(getTree()));
    }
}
