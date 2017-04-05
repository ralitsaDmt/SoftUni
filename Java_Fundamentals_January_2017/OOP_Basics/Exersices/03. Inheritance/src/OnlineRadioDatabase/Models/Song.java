package OnlineRadioDatabase.Models;

import OnlineRadioDatabase.Exceptions.InvalidArtistNameException;
import OnlineRadioDatabase.Exceptions.InvalidSongMinutesException;
import OnlineRadioDatabase.Exceptions.InvalidSongNameException;
import OnlineRadioDatabase.Exceptions.InvalidSongSecondsException;

public class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, int minutes, int seconds) throws InvalidArtistNameException, InvalidSongNameException, InvalidSongMinutesException, InvalidSongSecondsException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException();
        }

        this.songName = songName;
    }

    private void setMinutes(int minutes) throws InvalidSongMinutesException {
        if (minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException();
        }

        this.minutes = minutes;
    }

    private void setSeconds(int seconds) throws InvalidSongSecondsException {
        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException();
        }

        this.seconds = seconds;
    }

    public int getLengthInSeconds(){
        int totalLength = minutes * 60 + seconds;
        return totalLength;
    }
}
