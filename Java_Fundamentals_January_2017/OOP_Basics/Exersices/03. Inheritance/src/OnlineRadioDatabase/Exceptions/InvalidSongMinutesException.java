package OnlineRadioDatabase.Exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException{
    private final String INVALID_SONG_MINUTES_EXCEPTION_MESSAGE = "Song minutes should be between 0 and 14.";

    @Override
    public String getMessage() {
        return INVALID_SONG_MINUTES_EXCEPTION_MESSAGE;
    }
}
