package hva.exceptions;

import java.io.Serial;

public class AnimalNotFoundException extends Exception  {
    @Serial
	private static final long serialVersionUID = 202406100248L;

    private final String _animalId;
  
    public AnimalNotFoundException(String animalId) {
        super(animalId);
        _animalId = animalId;
    }

    public String getAnimalId() {
        return _animalId;
    }   
}
