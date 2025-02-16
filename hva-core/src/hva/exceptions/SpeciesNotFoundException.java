package hva.exceptions;

import java.io.Serial;

public class SpeciesNotFoundException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100251L;

    private final String _speciesId;

    public SpeciesNotFoundException(String speciesId) {
        _speciesId = speciesId;
    }

    public String getSpeciesId() {
        return _speciesId;
    }
}
