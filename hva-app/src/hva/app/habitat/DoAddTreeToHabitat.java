package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.DuplicateTreeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.TreeAlreadyExistsException;
import hva.exceptions.UnrecognizedEntryException;
import hva.exceptions.HabitatNotFoundException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
//FIXME import other classes if needed

class DoAddTreeToHabitat extends Command<Hotel> {

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            Form request = new Form();
            request.addStringField("idHabitat", Prompt.habitatKey());
            request.addStringField("idTree", Prompt.treeKey());
            request.addStringField("nameTree", Prompt.treeName());
            request.addStringField("ageTree", Prompt.treeAge());
            request.addStringField("difficultyTree", 
            Prompt.treeDifficulty());
            request.addOptionField("type",Prompt.treeType(),
            "CADUCA","PERENE");
            request.parse();
            String idHabitat = request.stringField("idHabitat");
            String idTree = request.stringField("idTree");
            String nameTree = request.stringField("nameTree");
            String ageTree = request.stringField("ageTree");
            String difficultyTree = request.stringField(
                "difficultyTree");
            String type = request.stringField("type");
            _display.popup(_receiver.addTreeToHabitat(
                idHabitat, idTree, nameTree, 
            ageTree, difficultyTree, type));
        } catch (TreeAlreadyExistsException e) {
            throw new DuplicateTreeKeyException(e.getTreeId());
        } catch (HabitatNotFoundException e) {
            throw new UnknownHabitatKeyException(e.getHabitatId());
        }
        catch (UnrecognizedEntryException e) {
            e.printStackTrace();
        }
    }

}
