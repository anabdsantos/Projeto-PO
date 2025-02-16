package hva.habitat.tree;

public class CadSummerState extends TreeCycleState{
    public CadSummerState (Tree tree) {
		super(tree, "COMFOLHAS", 2);
	}

    @Override
    public void next(){
        getTree().setState(new CadFallState(getTree()));
    }
}
