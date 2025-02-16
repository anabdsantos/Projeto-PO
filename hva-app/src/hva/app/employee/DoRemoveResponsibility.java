package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.EmployeeNotFoundException;
import hva.exceptions.NoSuchResponsibilityException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

class DoRemoveResponsibility extends Command<Hotel> {

    DoRemoveResponsibility(Hotel receiver) {
        super(Label.REMOVE_RESPONSABILITY, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
        Form request = new Form();
        request.addStringField("idEmployee", Prompt.employeeKey());
        request.addStringField("idResponsibility", 
        Prompt.responsibilityKey());
        request.parse();
        String idEmployee = request.stringField("idEmployee");
            String idResponsibility = request.stringField(
                "idResponsibility");
            _receiver.removeResponsibilitiesFromEmployee(idEmployee,
            idResponsibility);
                
        } catch (EmployeeNotFoundException e) {
            throw new UnknownEmployeeKeyException(e.getEmployeeId());
        } catch (NoSuchResponsibilityException e) {
            throw new NoResponsibilityException(e.getEmployeeId(), 
            e.getResponsibilityId());
        }  
    }
}


