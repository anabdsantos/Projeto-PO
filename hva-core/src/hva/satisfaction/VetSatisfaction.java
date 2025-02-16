package hva.satisfaction;

import hva.employee.Vet;

public class VetSatisfaction implements SatisfactionEmployee {
    private final Vet _vet;

    public VetSatisfaction(Vet vet) {
        _vet = vet;
    }
    
    @Override
    public double calculateEmployeeSatisfaction() {
        double work = _vet.vetWork();
        double satisfaction = 20-work;
        return satisfaction;
    }    
}
