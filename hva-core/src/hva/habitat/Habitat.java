package hva.habitat;

import hva.animal.Animal;
import hva.habitat.tree.Tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap; 

public class Habitat implements Serializable {
    private String _idHabitat;

    private String _name;

    private int _area;

    private int _nOfTrees;

    private int _nOfTrts;

    private Map<String,Animal> _animals;

    private Map<String,Integer> _influence;

    private Map<String,Tree> _treesOfHabitat;

    public Habitat(String id, String name, int area) {
        _idHabitat = id;
        _name = name;
        _area = area;
        _nOfTrees = 0;
        _nOfTrts = 0;

        _treesOfHabitat = new TreeMap<>(
            String.CASE_INSENSITIVE_ORDER);

        _animals = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        _influence = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    }

    public String getIdHabitat() {
        return _idHabitat;
    }

    public String getHabitatName() {
        return _name;
    }

    public int getArea() {
        return _area;
    }

    public void setArea(int area) {
        _area = area;
    }

    public int getNTrees() {
        return _nOfTrees;
    }

    public void setNTress(int n) {
        _nOfTrees = n;
    }

    public Map<String,Animal> getAnimals() {
        return _animals;
    }

    public void addAnimal(String id, Animal a) {
        _animals.put(id, a);
    }

    public void removeAnimal(String id) {
        _animals.remove(id);
    }

    public Map<String,Tree> getTrees() {
        return _treesOfHabitat;
    }

    public void addTree(String id, Tree t) {
        _treesOfHabitat.put(id, t);
        _nOfTrees++;
    }

    public int getNTrts() {
        return _nOfTrts;
    }

    public void increaseNTrts() {
        _nOfTrts++;
    }

    public int getInfluence(String idSpecies) {
        return _influence.get(idSpecies);
    }

    public void setInfluence(String idSpecies, int influence) {
        _influence.put(idSpecies,influence);
    }

    public boolean hasInfluence(String key) {
        return _influence.containsKey(key); 
    }

    public boolean existTreesInHabitat() {
        return !_treesOfHabitat.isEmpty();
    }

    public int animalsOfTheSameSpecies(String idSpecies) {
        int count = 0;
        for (Animal animal : _animals.values()) {
            if (animal.getIdSpecies().equals(idSpecies)) {
                count++;
            }
        }
        return count;
    }

    public int animalsOfDifferentSpecies(String idSpecies) {
        int count = 0;
        for (Animal animal : _animals.values()) {
            if ((!animal.getIdSpecies().equals(idSpecies))) {
                count++;
            }
        }
        return count;
    }
    
    public double habitatWork() {
        double cleaningEffort = 0;
        for (Tree trees : _treesOfHabitat.values()) {
            cleaningEffort+=trees.getCleaningEffort();
        }
        return _area + 3*_animals.size() + cleaningEffort;
    }
    
    /**
     * A collection of strings that represents all trees.
     * It uses each trees's toString().
     * @return a collection of strings.
     */
    public Collection<String> showTrees() {
        List<String> treesStrings = new ArrayList<>();
        for (Tree tree : _treesOfHabitat.values()) {
            treesStrings.add(tree.toString()); 
        }
        return Collections.unmodifiableCollection(treesStrings);
    }

    /**
     * A collection of strings that represents all animal of the habitat.
     * It uses each animals's toString().
     * @return a collection of strings.
     */
    public Collection<String> showAnimals() {
        List<String> animalsStrings = new ArrayList<>();
        for (Animal animal : _animals.values()) {
            animalsStrings.add(animal.toString()); 
        }
        return Collections.unmodifiableCollection(animalsStrings);
    }

    @Override
    public String toString() {
        return String.format(
            "HABITAT|%s|%s|%d|%d", _idHabitat, _name, _area, 
            _nOfTrees);
    }
}
