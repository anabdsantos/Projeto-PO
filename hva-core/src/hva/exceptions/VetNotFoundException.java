package hva.exceptions;

import java.io.Serial;

public class VetNotFoundException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100254L;

    private final String vetId;
  
    public VetNotFoundException(String vetId) {
        this.vetId = vetId;
    }

    public String getVetId() {
        return vetId;
    }   
}
