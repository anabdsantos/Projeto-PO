package hva.app.animal;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.AnimalAlreadyExistsException;
import hva.exceptions.HabitatNotFoundException;
import hva.exceptions.SpeciesAlreadyExistsException;
import hva.exceptions.SpeciesNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver); 
    }

    @Override
    protected final void execute() throws CommandException {
        Form request = new Form();
        request.addStringField("idAnimal", Prompt.animalKey());
        request.addStringField("animalName", Prompt.animalName());
        request.addStringField("idSpecies", Prompt.speciesKey());
        request.addStringField("idHabitat",hva.app.habitat.Prompt.
        habitatKey());
        request.parse();
        String idAnimal = request.stringField("idAnimal");
        String nameAnimal = request.stringField("animalName");
        String idSpecies = request.stringField("idSpecies");
        String idHabitat = request.stringField("idHabitat");
        
        try {
            _receiver.registerAnimal(new String[] {
            "ANIMAL", 
            idAnimal, 
            nameAnimal, 
            idSpecies,
            idHabitat, 
            });
        } catch (SpeciesNotFoundException e) {
            try {
                request.clear();
                request.addStringField("speciesName", 
                Prompt.speciesName());
                request.parse();

                _receiver.registerSpecies(new String[] {
                    "ESPÉCIE", 
                    idSpecies, 
                    request.stringField("speciesName"),
                });

                _receiver.registerAnimal(new String[] {
                "ANIMAL", 
                idAnimal, 
                nameAnimal, 
                idSpecies,
                idHabitat, 
                });
            } catch (HabitatNotFoundException e1) {
                throw new UnknownHabitatKeyException(e1.getHabitatId());
            } catch (AnimalAlreadyExistsException e1) {
                throw new DuplicateAnimalKeyException(e1.getAnimalId());
            } catch (SpeciesAlreadyExistsException | SpeciesNotFoundException e1) {
                e1.printStackTrace();
            } 
        } catch (AnimalAlreadyExistsException e) {
            throw new DuplicateAnimalKeyException(e.getAnimalId());
        } catch (HabitatNotFoundException e) {
            throw new UnknownHabitatKeyException(e.getHabitatId());
        }
    }
}


