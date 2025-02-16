package hva.app.search;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.AnimalNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

class DoShowMedicalActsOnAnimal extends Command<Hotel> {

    DoShowMedicalActsOnAnimal(Hotel receiver) {
        super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idAnimal", hva.app.animal.
            Prompt.animalKey());
            request.parse();
            String idAnimal = request.stringField("idAnimal");
            _display.popup(_receiver.showMedicalActsOnAnimal(
                idAnimal));
        } catch (AnimalNotFoundException e) {
            throw new UnknownAnimalKeyException(e.getAnimalId());
        }
    }

}
