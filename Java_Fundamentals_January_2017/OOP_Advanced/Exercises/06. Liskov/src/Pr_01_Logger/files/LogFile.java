package Pr_01_Logger.files;

public class LogFile implements CustomFile {

    private StringBuilder data;

    public LogFile(){
        this.data = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.data.append(message);
        this.data.append("\n");
    }

    @Override
    public int getSize() {
        int size = 0;

        for (int i = 0; i < data.length(); i++) {
            char character = data.charAt(i);
            if (Character.isLetter(character)) {
                size += character;
            }
        }

        return size;
    }
}
