package hva.habitat.tree;

public class Per extends Tree {
    public Per(String id, String name, int age, int cD) {
        super(id,name,age,cD);
    }

    @Override
    public String toString() {
        return String.format("ÁRVORE|%s|%s|%s|%s|PERENE|%s", 
        getIdTree(), getTreeName(), getTreeAge(),
        getCleaningDifficulty(), getCycle());
    }
}
