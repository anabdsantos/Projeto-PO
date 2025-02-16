package hva.exceptions;

import java.io.Serial;

public class HabitatAlreadyExistsException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100245L;

    private final String _habitatId;
 
    public HabitatAlreadyExistsException(String habitatId) {
        _habitatId = habitatId;
    }

    public String getHabitatId() {
        return _habitatId;
    }
}
