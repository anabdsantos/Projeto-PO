package hva.app.animal;

import hva.Hotel;
import hva.exceptions.AnimalNotFoundException;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.HabitatNotFoundException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoTransferToHabitat extends Command<Hotel> {

    DoTransferToHabitat(Hotel hotel) {
        super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);
    }

    @Override
    protected final void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idAnimal", Prompt.animalKey());
            request.addStringField("idHabitat", hva.app.habitat.
            Prompt.habitatKey());
            request.parse();
            String idAnimal = request.stringField("idAnimal");
            String idHabitat = request.stringField("idHabitat");
            _receiver.transferToHabitat(idAnimal, idHabitat);
        } catch(AnimalNotFoundException e) {
            throw new UnknownAnimalKeyException(e.getAnimalId());
        } catch(HabitatNotFoundException e) {
            throw new UnknownHabitatKeyException(e.getHabitatId());
        }
    }

}
