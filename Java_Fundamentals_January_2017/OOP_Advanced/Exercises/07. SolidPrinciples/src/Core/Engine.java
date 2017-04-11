package Core;

import contracts.CommandHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler)
    {
        this.commandHandler = commandHandler;
    }

    public void Run()
    {
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.equals("End")) {
                break;
            }

            String[] tokens = line.split("\\\\");
            String name = tokens[0];
            String[] parameters = new String[tokens.length - 1];
            System.arraycopy(tokens, 1, parameters, 0, parameters.length);

            try
            {
                String commandResult = this.commandHandler.ExecuteCommand(name, parameters);
                System.out.println(commandResult);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        CommandHandler commandHandler = new CommandHandlerImpl();
        Engine engine = new Engine(commandHandler);
        engine.Run();
    }
}
