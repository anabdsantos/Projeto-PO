package hva.exceptions;

import java.io.Serial;

public class EmployeeNotFoundException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100249L;

    private final String _employeeId;

    public EmployeeNotFoundException(String employeeId) {
        _employeeId = employeeId;
    }

    public String getEmployeeId() {
        return _employeeId;
    }  
}
