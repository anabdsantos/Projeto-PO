package hva.app.employee;

import hva.Hotel;
import hva.exceptions.EmployeeNotFoundException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoShowSatisfactionOfEmployee extends Command<Hotel> {

    DoShowSatisfactionOfEmployee(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        Form request = new Form();
        request.addStringField("idEmployee", Prompt.employeeKey());
        request.parse();
        String idEmployee = request.stringField("idEmployee");
        try {
            _display.popup(_receiver.showSatisfactionOfEmployee(
                idEmployee));
        } catch (EmployeeNotFoundException e) {
            throw new UnknownEmployeeKeyException(e.getEmployeeId());
        }
    }
}


