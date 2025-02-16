package hva.app.animal;


import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.AnimalNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
    }

    @Override
    protected final void execute() throws CommandException {
        Form request = new Form();
        request.addStringField("idAnimal", Prompt.animalKey());
        request.parse();
        String idAnimal = request.stringField("idAnimal");
        try {
            _display.popup(_receiver.showSatisfactionOfAnimal(
                idAnimal));
        } catch (AnimalNotFoundException e) {
            throw new UnknownAnimalKeyException(e.getAnimalId());
        }
    }
}
