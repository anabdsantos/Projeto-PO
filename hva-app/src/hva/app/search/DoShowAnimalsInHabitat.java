package hva.app.search;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.HabitatNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

class DoShowAnimalsInHabitat extends Command<Hotel> {

    DoShowAnimalsInHabitat(Hotel receiver) {
        super(Label.ANIMALS_IN_HABITAT, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idHabitat", hva.app.habitat.
            Prompt.habitatKey());
            request.parse();
            String idHabitat = request.stringField("idHabitat");
            _display.popup(_receiver.showAnimalsInHabitat(idHabitat));
        } catch (HabitatNotFoundException e) {
            throw new UnknownHabitatKeyException(e.getHabitatId());
        }
    }

}
