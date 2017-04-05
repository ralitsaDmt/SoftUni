package OnlineRadioDatabase.Exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException{
    private final String INVALID_SONG_SECONDS_EXCEPTION_MESSAGE = "Song seconds should be between 0 and 59.";

    @Override
    public String getMessage(){
        return this.INVALID_SONG_SECONDS_EXCEPTION_MESSAGE;
    }
}
