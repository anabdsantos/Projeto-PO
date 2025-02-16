package hva.animal;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Species implements Serializable {
    private final String _idSpecies;

    private final String _name;

    private Map<String,Animal> _animals;

    private int _nOfVets;

    public Species(String id, String name) {
        _name = name;
        _idSpecies = id;
        _animals = new HashMap<>();
        _nOfVets = 0;

    }

    public String getIdSpecies() {
        return _idSpecies;
    }

    public int getNVets() {
        return _nOfVets;
    }

    public String getSpeciesName() {
        return _name;
    }

    public Map<String,Animal> getAnimals() {
        return _animals;
    }

    public void increaseNVets() {
        _nOfVets++;
    }

    public void addAnimals(String id, Animal a) {
        _animals.put(id, a);
    }
   
}
