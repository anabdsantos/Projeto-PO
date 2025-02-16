package hva.exceptions;

import java.io.Serial;

public class EmployeeAlreadyExistsException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100244L;

    private final String _employeeId;
 
    public EmployeeAlreadyExistsException(String employeeId) {
        _employeeId = employeeId;
    }

    public String getEmployeeId() {
        return _employeeId;
    }   
}
