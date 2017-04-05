package OnlineRadioDatabase;

import OnlineRadioDatabase.Models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int songsCount = Integer.parseInt(reader.readLine());

        List<Song> playlist = new ArrayList<>();

        for (int i = 0; i < songsCount; i++) {
            String[] songData = reader.readLine().split(";");

            String artistName = songData[0];
            String songName = songData[1];

            String[] songLength = songData[2].split(":");
            int minutes = Integer.parseInt(songLength[0]);
            int seconds = Integer.parseInt(songLength[1]);

            try {
                Song song = new Song(artistName, songName, minutes, seconds);
                playlist.add(song);
                System.out.println("Song added.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int totalLengthInSeconds = 0;
        for (Song song : playlist) {
            totalLengthInSeconds = totalLengthInSeconds + song.getLengthInSeconds();
        }

        int hours = totalLengthInSeconds / 3600;
        int reminder = totalLengthInSeconds % 3600;
        int minutes = reminder / 60;
        int seconds = reminder % 60;

        System.out.println("Songs added: " + playlist.size());
        System.out.printf("Playlist length: %sh %sm %ss", hours, minutes, seconds);
    }
}
