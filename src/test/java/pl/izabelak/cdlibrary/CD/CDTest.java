package pl.izabelak.cdlibrary.CD;

import org.junit.jupiter.api.Test;
import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import static org.junit.jupiter.api.Assertions.*;

class CDTest {

    CD setup(){
        String title = "title";
        String author = "author";
        int releaseYear = 2001;
        String producer = "Warner Bross";
        Genre genre = Genre.JAZZ;
        boolean isOriginal = true;
        int discCount = 1;

        Track track = new TrackBuilder()
                .setTitle("title1")
                .setAuthor(author)
                .setGenre(genre)
                .setTime(30)
                .createTrack();

        Track track2 = new TrackBuilder()
                .setTitle("title2")
                .setAuthor(author)
                .setGenre(genre)
                .setTime(100)
                .createTrack();

        Track track3 = new TrackBuilder()
                .setTitle("title3")
                .setAuthor(author)
                .setGenre(genre)
                .setTime(80)
                .createTrack();

        CD cd = new CDBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setReleaseYear(releaseYear)
                .setProducer(producer)
                .setGenre(genre)
                .setIsOriginal(isOriginal)
                .setTrack(track)
                .setTrack(track2)
                .setTrack(track3)
                .createCD();

        return cd;
    }

    @Test
    void getTotalTime() {

        CD cd = setup();

        int totalTime = cd.getTotalTime();

        assertEquals(totalTime, 210);
    }

    @Test
    void getTotalTimeWithStream() {

        CD cd = setup();

        int totalTime = cd.getTotalTimeStream();

        assertEquals(totalTime, 210);
    }
}