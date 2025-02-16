package hva.app.search;

import hva.Hotel;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.exceptions.VetNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

class DoShowMedicalActsByVeterinarian extends Command<Hotel> {

    DoShowMedicalActsByVeterinarian(Hotel receiver) {
        super(Label.MEDICAL_ACTS_BY_VET, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idEmployee", hva.app.employee.
            Prompt.employeeKey());
            request.parse();
            String idEmployee = request.stringField("idEmployee");
            _display.popup(_receiver.showMedicalActsByVeterinarian(
                idEmployee));
        } catch (VetNotFoundException e) {
            throw new UnknownVeterinarianKeyException(e.getVetId());
        }
    }

}
