package hva.exceptions;

import java.io.Serial;

public class VaccineNotFoundException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100253L;

    private final String vaccineId;
 
    public VaccineNotFoundException(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineId() {
        return vaccineId;
    }   
}
