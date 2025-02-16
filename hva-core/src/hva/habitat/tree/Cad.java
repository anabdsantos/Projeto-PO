package hva.habitat.tree;

public class Cad extends Tree {
    public Cad(String id, String name, int age, int cD) {
        super(id,name,age,cD);
    }

    @Override
    public String toString() {
        return String.format("ÁRVORE|%s|%s|%s|%s|CADUCA|%s",
        getIdTree(), getTreeName(), getTreeAge(),
        getCleaningDifficulty(), getCycle());
    }
}
    
    
