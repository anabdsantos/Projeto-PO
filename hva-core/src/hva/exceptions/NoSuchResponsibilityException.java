package hva.exceptions;

import java.io.Serial;

public class NoSuchResponsibilityException extends Exception{
    @Serial
	private static final long serialVersionUID = 202406100256L;

    private final String _responsibilityId;
    private final String _employeeId;

      
    public NoSuchResponsibilityException(String employeeId, String responsibilityId ) {
        _employeeId = employeeId;
        _responsibilityId = responsibilityId;
    }

    public String getEmployeeId() {
        return _employeeId;
    }

    public String getResponsibilityId() {
        return _responsibilityId;
    }   
}
