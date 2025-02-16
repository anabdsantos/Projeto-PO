package hva.employee;

import hva.habitat.Habitat;
import hva.satisfaction.SatisfactionEmployee;
import hva.satisfaction.TrtSatisfaction;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Trt extends Employee implements Serializable {

    private final Map<String,Habitat> _idResponsibilities;

    public Trt(String id, String name) {
        super(id, name);
        _idResponsibilities = new TreeMap<>(
        String.CASE_INSENSITIVE_ORDER);

    }

    public Map<String,Habitat> getIdResponsibilities() {
        return _idResponsibilities;
    }

    @Override
    public String getType() {
        return "TRT";
    }

    @Override
    public SatisfactionEmployee getSatisfaction() {
        return new TrtSatisfaction(this);
    }

    public void addResponsibilities(String id, Habitat h) {
        _idResponsibilities.put(id, h);
    }

    public void removeResponsibilities(String id) {
        _idResponsibilities.remove(id);
    }
 
    public Habitat getResponsibility(String id) {
        return _idResponsibilities.get(id);
    }

    public double trtWork() {
        double work = 0;
        for (Habitat habitat: _idResponsibilities.values()) {
            double habitatWork = habitat.habitatWork();
            int nTrts = habitat.getNTrts();

            work += habitatWork / nTrts;
        }
        return work;
    }

    @Override
    public String toString() {
        String responsibilities = String.join(
            ",", _idResponsibilities.keySet());
        if (responsibilities.isEmpty()) {
            return String.format("TRT|%s|%s", 
            getEmployeeId(), getEmployeeName());
        } else {
            return String.format("TRT|%s|%s|%s",
            getEmployeeId(), getEmployeeName(), responsibilities);
        }
    }   
}
