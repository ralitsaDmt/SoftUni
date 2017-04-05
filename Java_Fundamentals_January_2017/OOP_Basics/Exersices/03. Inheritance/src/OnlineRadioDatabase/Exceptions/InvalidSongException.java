package OnlineRadioDatabase.Exceptions;

public abstract class InvalidSongException extends Exception{

    private final String INVALID_SONG_EXCEPTION_MESSAGE = "Invalid song.";

    private String message;

    public InvalidSongException(String message){
        this.setMessage(message);
    }

    public InvalidSongException(){
        this.setMessage(INVALID_SONG_EXCEPTION_MESSAGE);
    }

    private void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
