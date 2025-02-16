package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.HabitatNotFoundException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.SpeciesNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idHabitat", Prompt.habitatKey());
            request.addStringField("idSpecies", hva.app.animal.
            Prompt.speciesKey());
            request.addOptionField("influence",Prompt.
            habitatInfluence(),
            "POS","NEG","NEU");
            request.parse();
            String idHabitat = request.stringField("idHabitat");
            String idSpecies = request.stringField("idSpecies");
            String influence = request.stringField("influence");
            _receiver.changeHabitatInfluence(idHabitat, idSpecies,
            influence);
        } catch(HabitatNotFoundException e) {
            throw new UnknownHabitatKeyException(e.getHabitatId());
        } catch(SpeciesNotFoundException e) {
            throw new UnknownSpeciesKeyException(e.getSpeciesId());
        }
    }

}
