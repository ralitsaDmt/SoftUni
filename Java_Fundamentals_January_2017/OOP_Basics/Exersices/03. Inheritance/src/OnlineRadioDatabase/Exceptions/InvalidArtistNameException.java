package OnlineRadioDatabase.Exceptions;

public class InvalidArtistNameException extends InvalidSongException {
    private final String INVALID_ARTIST_NAME_EXCEPTION_MESSAGE = "Artist name should be between 3 and 20 symbols.";

    @Override
    public String getMessage(){
        return INVALID_ARTIST_NAME_EXCEPTION_MESSAGE;
    }
}
