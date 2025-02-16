package hva.exceptions;

import java.io.Serial;

public class UnauthorizedVetException extends Exception {
    @Serial
	private static final long serialVersionUID = 202406100255L;

    private final String _employeeId;

    private final String _speciesId;

    public UnauthorizedVetException(String employeeId, String speciesId) {
        _employeeId = employeeId;
        _speciesId = speciesId;
    }

    public String getVetId() {
        return _employeeId;
    }

    public String getSId() {
        return _speciesId;
    }  
}
