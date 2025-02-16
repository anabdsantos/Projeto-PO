package hva.exceptions;

import java.io.Serial;

public class VaccineAlreadyExistsException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100247L;

    private final String _vaccineId;

      
    public VaccineAlreadyExistsException(String vaccineId) {
        _vaccineId = vaccineId;
    }

    public String getVaccineId() {
        return _vaccineId;
    }   
}
