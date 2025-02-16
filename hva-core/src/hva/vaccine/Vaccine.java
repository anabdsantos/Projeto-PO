package hva.vaccine;

import hva.animal.Species;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Vaccine implements Serializable {
    private String _idVaccine;

    private String _name;

    private int _nApplications;

    private Map<String, Species> _species;

    public Vaccine(String id, String name) {
        _idVaccine = id;
        _name = name;
        _nApplications = 0;
        _species = new HashMap<>();
    }

    public String getIdVaccine() {
        return _idVaccine;
    }

    public String getName() {
        return _name;
    }

    public int getNApllications() {
        return _nApplications;
    }

    public Species getSpecificSpecies(String id) {
        return _species.get(id);
    }

    public void increaseNApllications() {
        _nApplications++;
    }

    public Map<String,Species> getAllSpecies() {
        return _species;
    }

    public void addSpecies(String id, Species s) {
        _species.put(id, s);
    }

    public boolean canVaccinateSpecies(String id) {
        return _species.get(id) != null;
    }

    public boolean hasResponsibility() {
        return _species!=null;
    }

    /**
     * 
     * @param idSpecies
     * @return
     */
    public int calculateDamage(String speciesName) {
        int damage = 0;
        for (Species compatibleSpecies: _species.values()) {
            String compatiblename = compatibleSpecies.
            getSpeciesName();

            int namesSize = Math.max(speciesName.length(),
            compatiblename.length());

            int commonChar = calculateCommonChars(speciesName,
            compatiblename);

            int currentDamage = namesSize - commonChar;

            damage = Math.max(damage,currentDamage);
        }
        if (!hasResponsibility()) {
            damage = speciesName.length();
        }
        return damage;
    }

    /**
     * 
     * @param name1
     * @param name2
     * @return
     */
    public int calculateCommonChars(String name1, String name2) {
        int counter = 0;
        String bigName = name1.length() >= name2.length() ? 
        name1.toLowerCase() : name2.toLowerCase();
        String smallName = name1.length() >= name2.length() ? 
        name2.toLowerCase() : name1.toLowerCase();
        for (int i = 0; i < bigName.length(); i++) {
            if (smallName.indexOf(bigName.charAt(i))!=-1) {
                counter++;
            }
        }
        return counter;  
    }

    /**
     * 

     * @param idSpecies
     * @return
     */
    public boolean animalCanBeVaccinated(String id) {
        return _species.get(id) != null;
    }

    @Override
    public String toString() {
        String especies = String.join(",", _species.keySet());
        if (especies.isEmpty()) {
            return String.format(
                "VACINA|%s|%s|%d", _idVaccine, _name, _nApplications);
        } else {
            return String.format(
                "VACINA|%s|%s|%d|%s", _idVaccine, _name, 
                _nApplications, especies);
        }
    } 
}
