package P02_FileStream;

public class Main {
    public static void main(String[] args) {
        StreamProgressInfo fileInfo = new StreamProgressInfo(new File(20, 20, "Name"));
        StreamProgressInfo musicInfo = new StreamProgressInfo(new Music(20, 20, "Control", "Lele kako"));

        int filePercent = fileInfo.calculateCurrentPercent();
        int musicPercent = musicInfo.calculateCurrentPercent();


    }
}
