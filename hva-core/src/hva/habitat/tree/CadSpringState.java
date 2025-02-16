package hva.habitat.tree;

public class CadSpringState extends TreeCycleState{
    public CadSpringState (Tree tree) {
		super(tree, "GERARFOLHAS", 1);
	}

    @Override
    public void next(){
        getTree().setState(new CadSummerState(getTree()));
    }
}
