package Problem_02_WarningLevels;

public interface Logger {
    void addMessage(Message message);

    Iterable<Message> getMessages();
}
