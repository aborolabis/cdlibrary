package pl.izabelak.cdlibrary.Track;

import org.junit.jupiter.api.Test;
import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TrackBuilderTest {

    @Test
    void creatingNewTrack() {
        String title = "title";
        String author = "author";
        Genre genre = Genre.ROCK;
        Genre genre2 = Genre.CLASSICAL;
        Set<Genre> setOfGenres = new HashSet<>();
        setOfGenres.add(genre);
        setOfGenres.add(genre2);
        int time = 100;

        Track track = new TrackBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setGenres(setOfGenres)
                .setTime(time)
                .createTrack();


        assertEquals(title, track.getTitle());
        assertEquals(author, track.getAuthor());
        assertEquals(setOfGenres, track.getGenres());
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
        assertEquals(null, track.getGenres());
        assertEquals(time, track.getTime());
    }
}