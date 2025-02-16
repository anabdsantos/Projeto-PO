package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.HabitatNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

class DoChangeHabitatArea extends Command<Hotel> {

    DoChangeHabitatArea(Hotel receiver) {
        super(Label.CHANGE_HABITAT_AREA, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idHabitat", Prompt.habitatKey());
            request.addIntegerField("area", Prompt.habitatArea());
            request.parse();
            
            String idHabitat = request.stringField("idHabitat");
            int area = request.integerField("area");
            _receiver.changeHabitatArea(idHabitat,area);
        }
        catch(HabitatNotFoundException e) {
            throw new UnknownHabitatKeyException(e.getHabitatId());
        }
    }

}
