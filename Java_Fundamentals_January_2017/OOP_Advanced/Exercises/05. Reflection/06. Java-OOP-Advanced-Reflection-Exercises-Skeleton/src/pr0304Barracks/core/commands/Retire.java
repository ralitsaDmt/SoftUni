package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Alias;
import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Alias("retire")
public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        String unitName = this.getData()[1];
        String result;
        try {
            this.repository.removeUnit(unitName);
            result = String.format("%s retired!", unitName);
        } catch (NotImplementedException ex) {
            result = "No such units in repository.";
        }
        return result;
    }
}
