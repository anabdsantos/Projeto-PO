package hva.employee;

import hva.animal.Species;
import hva.satisfaction.SatisfactionEmployee;
import hva.satisfaction.VetSatisfaction;
import hva.vaccine.MedicalActs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Vet extends Employee implements Serializable{

    private final Map<String,Species> _idResponsibilities;

    private List<MedicalActs> _vaccinations;

    public Vet(String id, String name) {
        super(id, name);
        _idResponsibilities = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);
        _vaccinations = new ArrayList<>();
    }
    
    public Map<String,Species> getIdResponsibilities() {
        return _idResponsibilities;
    }

    public List<MedicalActs> getVetMedicalActs() {
        return _vaccinations;
    }

    public void addVetMedicalAct(MedicalActs medicalAct) {
        _vaccinations.add(medicalAct);
    }

    public void addResponsibilities(String id, Species s) {
        _idResponsibilities.put(id, s);
    }

    public void removeResponsibilities(String id) {
        _idResponsibilities.remove(id);
    }

    public Species getResponsibility(String id) {
        return _idResponsibilities.get(id);
    }

    public boolean hasSpecies(String id) {
        return _idResponsibilities.get(id) != null;
    }

    public double vetWork() {
        double work = 0;
        for (Species species : _idResponsibilities.values()) {
            int population = species.getAnimals().size();
            int nVets = species.getNVets();

            work += population/nVets;
        }
        return work;
    }

    @Override
    public String getType() {
        return "VET";
    }

    @Override
    public SatisfactionEmployee getSatisfaction() {
        return new VetSatisfaction(this);
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
        String responsibilities = String.join(
            ",", _idResponsibilities.keySet());
        if (responsibilities.isEmpty()) {
            return String.format("VET|%s|%s", getEmployeeId(), 
            getEmployeeName());
        } else {
            return String.format("VET|%s|%s|%s", 
            getEmployeeId(),
            getEmployeeName(), responsibilities);
        }
    }
}
