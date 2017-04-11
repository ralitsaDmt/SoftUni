package Problem_02_WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String minimumImportance = reader.readLine();

        Logger logger = new LoggerImpl(minimumImportance);

        while (true) {
            String input = reader.readLine();
            if (input.equals("END")) {
                break;
            }

            String[] messageData = input.split(":");
            String importance = messageData[0];
            String content = messageData[1].trim();

            Message message = new Message(importance, content);

            logger.addMessage(message);
        }

        Iterable<Message> loggedMessages = logger.getMessages();

        for (Message loggedMessage : loggedMessages) {
            System.out.println(loggedMessage);
        }

    }
}
