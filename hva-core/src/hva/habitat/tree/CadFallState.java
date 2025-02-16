package hva.habitat.tree;

public class CadFallState extends TreeCycleState{
    public CadFallState (Tree tree) {
		super(tree, "LARGARFOLHAS", 5);
	}

    @Override
    public void next(){
        getTree().setState(new CadWinterState(getTree()));
    }
}
