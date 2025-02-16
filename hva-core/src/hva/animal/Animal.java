package hva.animal;

import hva.habitat.Habitat;
import hva.satisfaction.BasicAnimalSatisfaction;
import hva.satisfaction.SatisfactionAnimal;
import hva.vaccine.MedicalActs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Animal extends Species implements Serializable {

    private String _idAnimal;

    private String _name;

    private List<String> _healthHistorial;

    private List<MedicalActs> _vaccinations;

    private Habitat _habitat;

    public Animal(String id, String name, String speciesName,
    String speciesId, Habitat habitat) {
        super(speciesId, speciesName);  
        _idAnimal = id;
        _name = name;
        _habitat = habitat;
        _vaccinations = new ArrayList<>();
        _healthHistorial = new ArrayList<>();
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getAnimalId() {
        return _idAnimal;
    }

    public void setId(String id) {
        _idAnimal = id;
    }

    public Habitat getAnimalHabitat() {
        return _habitat;
    }

    public void setHabitat(Habitat h) {
        _habitat = h; 
    }

    public List<MedicalActs> getAnimalMedicalActs() {
        return _vaccinations;
    }

    public void addAnimalMedicalAct(MedicalActs medicalAct) {
        _vaccinations.add(medicalAct);
    }

    public String getHealthHistorial() {
        return String.join(",", _healthHistorial);
    }

    public void updateHeatlhHistorial(String health) {
        _healthHistorial.add(health);
    }

    public SatisfactionAnimal getAnimalSatisfaction() {
        return new BasicAnimalSatisfaction(this);
    }

    public void addHealthHistorial(int damage) {
        String health;
        if (damage == 0) {
            health = "CONFUSÃO";
        } else if (damage <= 4) {
            health = "ACIDENTE";
        } else {
            health = "ERRO";
        }
        updateHeatlhHistorial(health);
    }

    public Collection<String> showMedicalActs() {
        List<String> vaccinationsStrings = new ArrayList<>();
        for (MedicalActs medicalAct : _vaccinations) {
            vaccinationsStrings.add(medicalAct.toString()); 
        }
        return Collections.unmodifiableCollection(
            vaccinationsStrings);
    }
 
    @Override
    public String toString() {
        String health = ( _healthHistorial.isEmpty() ) ? "VOID" : 
        getHealthHistorial();
        return String.format("ANIMAL|%s|%s|%s|%s|%s",
         _idAnimal,
        _name, getIdSpecies(), health, _habitat.getIdHabitat()); 
    }

}






