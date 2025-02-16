package hva.habitat.tree;

public class CadWinterState extends TreeCycleState{
    public CadWinterState (Tree tree) {
		super(tree, "SEMFOLHAS", 0);
	}

    @Override
    public void next(){
        getTree().setState(new CadSpringState(getTree()));
    }
}
