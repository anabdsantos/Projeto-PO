package hva.app.employee;


import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.EmployeeNotFoundException;
import hva.exceptions.NoSuchResponsibilityException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoAddResponsibility extends Command<Hotel> {

    DoAddResponsibility(Hotel receiver) {
        super(Label.ADD_RESPONSABILITY, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idEmployee", Prompt.
            employeeKey());
            request.addStringField("idResponsibility", Prompt.
            responsibilityKey());
            request.parse();
            String idEmployee = request.stringField("idEmployee");
            String idResponsibility = request.stringField(
                "idResponsibility");
            _receiver.addResponsibilityToEmployee(idEmployee,
            idResponsibility);
            
            
        } catch (EmployeeNotFoundException e) {
            throw new UnknownEmployeeKeyException(e.getEmployeeId());
        } catch (NoSuchResponsibilityException e) {
            throw new NoResponsibilityException(e.getEmployeeId(), 
            e.getResponsibilityId());
        }
    }

}
