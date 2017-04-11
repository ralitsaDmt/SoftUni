package pr0304Barracks.core;

import pr0304Barracks.annotations.Alias;
import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;

public class CommandInterpreter {

    private static final String COMMANDS_LOCATION = "src/pr0304Barracks/core/commands";
    private static final String COMMAND_PACKAGE = "pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreter(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String interpretCommand(String[] data, String commandName) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Executable command = parseCommand(data, commandName);
        //String result = command.execute();
        //return result;

        return "";
    }

    private Executable parseCommand(String[] data, String command) {

        File commandsFolder = new File(COMMANDS_LOCATION);
        Executable executable = null;

        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }

            try {
                String className = file.getName()
                        .substring(0, file.getName().lastIndexOf('.'));
                Class<Executable> exeClass = (Class<Executable>) Class.forName(COMMAND_PACKAGE + className);

                if (!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }

                Alias alias = exeClass.getAnnotation(Alias.class);
                String value = alias.value();
                if (!value.equalsIgnoreCase(command)) {
                    continue;
                }

                Constructor exeConstructor = exeClass.getConstructor(String[].class);
                executable = (Executable) exeConstructor.newInstance(data);

                this.injectDependencies(executable, exeClass);

            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

        return executable;
    }

    private void injectDependencies(Executable executable, Class<Executable> exeClass) throws IllegalAccessException {
        Field[] exeFields = exeClass.getDeclaredFields();
        for (Field fieldToSet : exeFields) {
            if (!fieldToSet.isAnnotationPresent(Inject.class)) {
                continue;
            }
            fieldToSet.setAccessible(true);

            Field[] theseFields = CommandInterpreter.class.getDeclaredFields();
            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(fieldToSet.getType())) {
                    continue;
                }
                thisField.setAccessible(true);
                fieldToSet.set(executable, thisField.get(this));
            }
        }
    }
}
