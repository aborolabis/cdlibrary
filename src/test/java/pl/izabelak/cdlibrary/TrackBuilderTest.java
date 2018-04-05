package pl.izabelak.cdlibrary;

import org.junit.jupiter.api.Test;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import static org.junit.jupiter.api.Assertions.*;

class TrackBuilderTest {

    @Test
    void creatingNewTrack() {
        String title = "title";
        String author = "author";
        Genre genre = Genre.ROCK;
        int time = 100;

        Track track = new TrackBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setGenre(genre)
                .setTime(time)
                .createTrack();


        assertEquals(title, track.getTitle());
        assertEquals(author, track.getAuthor());
        assertEquals(genre, track.getGenre());
        assertEquals(time, track.getTime());
    }

    @Test
    void creatingNewTrackWithoutSomeParameters() {
        String author = "author";
        int time = 100;

        Track track = new TrackBuilder()
                .setAuthor(author)
                .setTime(time)
                .createTrack();

        assertEquals(null, track.getTitle());
        assertEquals(author, track.getAuthor());
        assertEquals(null, track.getGenre());
        assertEquals(time, track.getTime());
    }
}