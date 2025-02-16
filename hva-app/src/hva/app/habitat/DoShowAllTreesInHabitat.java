package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.HabitatNotFoundException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoShowAllTreesInHabitat extends Command<Hotel> {

    DoShowAllTreesInHabitat(Hotel receiver) {
        super(Label.SHOW_TREES_IN_HABITAT, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idHabitat", Prompt.habitatKey());
            request.parse();
            String idHabitat = request.stringField("idHabitat");
            _display.popup(_receiver.showAllTreesInHabitat(
                idHabitat));
        }
        catch (HabitatNotFoundException e) {
            throw new UnknownHabitatKeyException(e.getHabitatId());
        }
    }

}
