package P02_FileStream;

public class Music extends BaseStream {

    private String artist;
    private String album;

    protected Music(int bitesSent, int length, String artist, String album) {
        super(bitesSent, length);
        this.album = album;
        this.artist = artist;
    }
}
