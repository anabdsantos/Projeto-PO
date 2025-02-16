package hva.app.main;

import hva.HotelManager;
import hva.exceptions.MissingFileAssociationException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;

import java.io.FileNotFoundException;
import java.io.IOException;
//FIXME import other classes if needed

class DoSaveFile extends Command<HotelManager> {
    DoSaveFile(HotelManager receiver) {
        super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
    }

    @Override
    protected final void execute() {
    	try {
            _receiver.save();
        } catch (MissingFileAssociationException e) {
            Form request = new Form();
            request.addStringField("filename", Prompt.newSaveAs());
            request.parse();
            String filename = request.stringField("filename");
            try {
                _receiver.saveAs(filename);
            } catch (MissingFileAssociationException | IOException e1) {
                e1.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
