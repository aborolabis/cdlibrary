package pl.izabelak.cdlibrary.Track;

import org.junit.jupiter.api.Test;
import pl.izabelak.cdlibrary.Genre;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    void testToString() {

        Track track = new TrackBuilder()
                .setTitle("title")
                .setAuthor("author")
                .setTime(120)
                .setGenre(Genre.SOUL)
                .setGenre(Genre.BLUES)
                .createTrack();

        String s = track.toString();

        System.out.println(s);
    }
}