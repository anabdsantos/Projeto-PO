package hva.satisfaction;

import hva.employee.Trt;

public class TrtSatisfaction implements SatisfactionEmployee {
    private Trt _trt;

    public TrtSatisfaction(Trt trt) {
        _trt=trt;
    }

    @Override
    public double calculateEmployeeSatisfaction() {
        double work = _trt.trtWork();
        double satisfaction = 300 - work;
        return satisfaction;
    } 
}
