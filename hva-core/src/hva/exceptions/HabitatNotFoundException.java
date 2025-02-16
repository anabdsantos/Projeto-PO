package hva.exceptions;

import java.io.Serial;

public class HabitatNotFoundException extends Exception {
    @Serial
	private static final long serialVersionUID = 202406100250L;

    private final String _habitatId;

    public HabitatNotFoundException(String habitatId) {
        _habitatId = habitatId;
    }

    public String getHabitatId() {
        return _habitatId;
    } 
}
