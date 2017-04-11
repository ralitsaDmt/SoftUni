package Problem_02_WarningLevels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoggerImpl implements Logger {

    private int minimumImportanceLevel;
    private List<Message> messages;

    public LoggerImpl(String minimumImportance){
        this.minimumImportanceLevel = Enum.valueOf(Importance.class, minimumImportance).ordinal();
        this.messages = new ArrayList<>();
    }


    @Override
    public void addMessage(Message message) {

        int messageImportanceLevel = message.getImportanceLevel();
        if (messageImportanceLevel >= minimumImportanceLevel){
            this.messages.add(message);
        }
    }

    @Override
    public Iterable<Message> getMessages() {
        return Collections.unmodifiableCollection(this.messages);
    }
}
