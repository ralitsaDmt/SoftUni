package Problem_02_WarningLevels;

public class Message {
    private Importance importance;
    private String content;

    public Message(String importance, String content) {

        this.importance = Enum.valueOf(Importance.class, importance.toUpperCase());
        this.content = content;
    }

    public int getImportanceLevel(){
        return this.importance.ordinal();
    }

    @Override
    public String toString() {
        String output = String.format("%s: %s",
                this.importance, this.content);
        return output;
    }
}
