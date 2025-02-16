package hva.habitat.tree;

public class PerSummerState extends TreeCycleState{
    public PerSummerState (Tree tree) {
		super(tree, "COMFOLHAS", 1);
	}

    @Override
    public void next(){
        getTree().setState(new PerFallState(getTree()));
    }
}
