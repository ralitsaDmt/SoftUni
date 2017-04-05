package OnlineRadioDatabase.Exceptions;

public class InvalidSongLengthException extends InvalidSongException{
    private final String INVALID_SONG_LENGTH_EXCPETION_MESSAGE = "Invalid song length.";

    @Override
    public String getMessage(){
        return this.INVALID_SONG_LENGTH_EXCPETION_MESSAGE;
    }
}
