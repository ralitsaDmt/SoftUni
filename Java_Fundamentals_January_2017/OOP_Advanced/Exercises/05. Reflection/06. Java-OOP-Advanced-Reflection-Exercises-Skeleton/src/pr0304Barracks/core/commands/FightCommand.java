package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Alias;

@Alias("fight")
public class FightCommand extends Command {

    public FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return "fight";
    }
}
