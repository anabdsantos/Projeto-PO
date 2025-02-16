package hva.app.habitat;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import hva.app.exceptions.DuplicateHabitatKeyException;
import hva.app.exceptions.UnknownTreeKeyException;
import hva.exceptions.HabitatAlreadyExistsException;
import hva.exceptions.TreeNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoRegisterHabitat extends Command<Hotel> {

    DoRegisterHabitat(Hotel receiver) {
        super(Label.REGISTER_HABITAT, receiver);
    }
  
    @Override
    protected final void execute() throws CommandException {
      try {

        Form request = new Form();
        request.addStringField("idHabitat", Prompt.habitatKey());
        request.addStringField("habitatName", Prompt.habitatName());
        request.addIntegerField("area", Prompt.habitatArea());
        request.parse();
        
        _receiver.registerHabitat(new String[] { 
            "HABITAT", request.stringField("idHabitat"), 
            request.stringField("habitatName"), 
            String.valueOf(request.integerField("area"))
        });
      } catch (HabitatAlreadyExistsException e) {
        throw new DuplicateHabitatKeyException(e.getHabitatId());
      } catch (TreeNotFoundException e) {
        throw new UnknownTreeKeyException(e.getTreeId());
      } 
    }
    
  }