package hva.app.vaccine;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.SpeciesNotFoundException;
import hva.exceptions.VaccineAlreadyExistsException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoRegisterVaccine extends Command<Hotel> {

    
    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
    }
  
    @Override
    protected final void execute() throws CommandException {
      try {
        Form request = new Form();
        request.addStringField("idVaccine", Prompt.vaccineKey());
        request.addStringField("vaccineName", Prompt.vaccineName());
        request.addStringField("listOfSpecies",
        Prompt.listOfSpeciesKeys());
        request.parse();
    
        _receiver.registerVaccine(new String[] { 
            "VACINA", request.stringField("idVaccine"),
            request.stringField("vaccineName"), 
            request.stringField("listOfSpecies")
        });
      } catch (VaccineAlreadyExistsException e) {
        throw new DuplicateVaccineKeyException(e.getVaccineId());
      } catch ( SpeciesNotFoundException e) {
        throw new UnknownSpeciesKeyException(e.getSpeciesId());
      }
    }
    
  }
  