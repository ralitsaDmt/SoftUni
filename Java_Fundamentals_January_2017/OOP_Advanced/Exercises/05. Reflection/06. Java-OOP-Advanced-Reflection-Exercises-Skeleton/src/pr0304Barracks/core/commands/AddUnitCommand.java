package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Alias;
import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

@Alias("add")
public class AddUnitCommand extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddUnitCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
