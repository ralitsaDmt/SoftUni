package OnlineRadioDatabase.Exceptions;

public class InvalidSongNameException extends InvalidSongException{
    private final String INVALID_SONG_NAME_EXCEPTION_MESSAGE = "Song name should be between 3 and 30 symbols.";

    @Override
    public String getMessage() {
        return INVALID_SONG_NAME_EXCEPTION_MESSAGE;
    }
}
