package hva.habitat.tree;

public class PerSpringState extends TreeCycleState{
    public PerSpringState (Tree tree) {
		super(tree, "GERARFOLHAS", 1);
	}
    
    @Override
    public void next(){
        getTree().setState(new PerSummerState(getTree()));
    }
}
