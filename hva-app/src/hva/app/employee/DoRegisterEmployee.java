package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import hva.app.exceptions.DuplicateEmployeeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.EmployeeAlreadyExistsException;
import hva.exceptions.HabitatNotFoundException;
import hva.exceptions.SpeciesNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterEmployee extends Command<Hotel> {

    
    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        //FIXME add command fields if needed
    }

    /** @see ist.po.ui.Command#execute() */
    @Override
    protected final void execute() throws CommandException {
      try {
        Form request = new Form();
        request.addStringField("idEmployee", Prompt.employeeKey());
        request.addStringField("nameEmployee", Prompt.employeeName());
        request.addOptionField("type",Prompt.employeeType(),"TRT",
        "VET");
        request.parse();
        String idEmployee = request.stringField("idEmployee");
        String nameEmployee = request.stringField("nameEmployee");
        String type = request.stringField("type");
        switch (type) {
            case "VET" -> type = "VETERINÁRIO";
            case "TRT" -> type = "TRATADOR";
        }
        _receiver.registerEmployee(new String[] { 
            type, idEmployee, 
            nameEmployee
        });
      } catch (EmployeeAlreadyExistsException e) {
        throw new DuplicateEmployeeKeyException(e.getEmployeeId());
      } catch (HabitatNotFoundException e) {
        throw new UnknownHabitatKeyException(e.getHabitatId());
      } catch (SpeciesNotFoundException e) {
        throw new UnknownSpeciesKeyException(e.getSpeciesId());
      } 
    }
    
  }
  
  