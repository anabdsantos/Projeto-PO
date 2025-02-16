package hva.habitat.tree;

import java.io.Serializable;

public class Tree implements Serializable {
    private String _idTree;
    
    private String _name;

    private int _age;

    private int _cleaningDifficulty;

    private Season _inicialSeason;

    private TreeCycleState _state;

    public Tree(String id, String name, int age, int cD) {
        _idTree = id;
        _name = name;
        _age = age;
        _cleaningDifficulty = cD;
    }
    
    public String getIdTree() {
        return _idTree;
    }

    public String getTreeName() {
        return _name;
    }

    public int getTreeAge() {
        return _age;
    }

    public void setTreeAge(int n) {
        _age = n;
    }

    public void setState(TreeCycleState state) {
        _state = state;
    }

    public void setInicialSeason(Season season) {
        _inicialSeason = season;
    }

    public void advance(Season newSeason) {
        _state.next();
        if (_inicialSeason.getValue() == newSeason.getValue()) {
            setTreeAge(++_age);
        }
    }
    
    public double getCleaningEffort() {
        return _cleaningDifficulty*_state.
        getSeasonalEffort()*Math.log(_age+1);
    }

    public int getCleaningDifficulty() {
        return _cleaningDifficulty;
    }

    public String getCycle() {
        return _state.getCycle();
    }
}
