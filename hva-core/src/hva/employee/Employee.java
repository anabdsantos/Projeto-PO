package hva.employee;

import hva.satisfaction.SatisfactionEmployee;
import java.io.Serializable;

public abstract class Employee implements Serializable {

    private  String _name;

    private String _idEmployee;


    public Employee(String id, String name) {
        _name = name;
        _idEmployee = id;
    }

    public String getEmployeeName() {
        return _name;
    }

    public String getEmployeeId() {
        return _idEmployee;
    }

    public abstract String getType();

    public abstract SatisfactionEmployee getSatisfaction();

    @Override
    public abstract String toString();
   
}
