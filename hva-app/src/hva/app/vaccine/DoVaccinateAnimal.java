package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.exceptions.UnknownVaccineKeyException;
import hva.app.exceptions.VeterinarianNotAuthorizedException;
import hva.exceptions.AnimalNotFoundException;
import hva.exceptions.UnauthorizedVetException;
import hva.exceptions.VaccineNotFoundException;
import hva.exceptions.VetNotFoundException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);
    }

    @Override
    protected final void execute() throws CommandException {
        Form request = new Form();
        request.addStringField("idVaccine", Prompt.vaccineKey());
        request.addStringField("idVet", Prompt.veterinarianKey());
        request.addStringField("idAnimal",hva.app.animal.Prompt.
        animalKey());
        request.parse();

        String idVaccine = request.stringField("idVaccine");
        String idVet = request.stringField("idVet");
        String idAnimal = request.stringField("idAnimal");

        try {
            _receiver.vaccinateAnimal(idVaccine, idVet, idAnimal);
            if (!_receiver.vaccineIsGoodToAnimal(idVaccine, idAnimal)
            ) {
                _display.popup(Message.wrongVaccine(idVaccine,
                idAnimal));
            }    
        } catch (VetNotFoundException e) {
            throw new UnknownVeterinarianKeyException(e.getVetId());
        } catch (UnauthorizedVetException e) {
            throw new VeterinarianNotAuthorizedException(e.getVetId()
            , e.getSId());
        } catch (VaccineNotFoundException e ) {
            throw new UnknownVaccineKeyException(e.getVaccineId());
        } catch (AnimalNotFoundException e ) {
            throw new UnknownAnimalKeyException(e.getAnimalId());
        }

    }

}
