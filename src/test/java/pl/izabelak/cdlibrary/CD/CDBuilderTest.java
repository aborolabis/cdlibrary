package pl.izabelak.cdlibrary.CD;

import org.junit.jupiter.api.Test;
import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CDBuilderTest {


    @Test
    void createFullCD() {

        String title = "title";
        String author = "author";
        int releaseYear = 2001;
        String producer = "Warner Bross";

        Genre genre = Genre.JAZZ;
        Genre genre2  = Genre.DISCO;
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);
        genres.add(genre2);

        Genre genre3 = Genre.HIP_HOP;
        Genre genre4  = Genre.TECHNO;
        Set<Genre> genres2 = new HashSet<>();
        genres2.add(genre3);
        genres2.add(genre4);

        Genre genre5 = Genre.METAL;
        Genre genre6  = Genre.POP;
        Set<Genre> genres3 = new HashSet<>();
        genres3.add(genre5);
        genres3.add(genre6);

        boolean isOriginal = true;
        int discCount = 1;

        Track track = new TrackBuilder()
                .setTitle("title1")
                .setAuthor(author)
                .setGenres(genres)
                .setTime(30)
                .createTrack();

        Track track2 = new TrackBuilder()
                .setTitle("title2")
                .setAuthor(author)
                .setGenres(genres2)
                .setTime(100)
                .createTrack();

        Track track3 = new TrackBuilder()
                .setTitle("title3")
                .setAuthor(author)
                .setGenres(genres3)
                .setTime(80)
                .createTrack();

        CD cd = new CDBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setReleaseYear(releaseYear)
                .setProducer(producer)
                .setIsOriginal(isOriginal)
                .setTrack(track)
                .setTrack(track2)
                .setTrack(track3)
                .createCD();

        assertEquals(title, cd.getTitle());
        assertEquals(author, cd.getAuthor());
        assertEquals(releaseYear, cd.getReleaseYear());
        assertEquals(producer, cd.getProducer());
        assertEquals(isOriginal, cd.isOriginal());
        assertEquals("title1", cd.getTracks().get(0).getTitle());
        assertEquals("title2", cd.getTracks().get(1).getTitle());
        assertEquals("title3", cd.getTracks().get(2).getTitle());
        assertEquals(genres, cd.getTracks().get(0).getGenres());
        assertEquals(genres2, cd.getTracks().get(1).getGenres());
        assertEquals(genres3, cd.getTracks().get(2).getGenres());
    }

    @Test
    void testCDBuilder() {
        Track track1 = new TrackBuilder()
                .setTitle("title1")
                .createTrack();
        Track track2 = new TrackBuilder()
                .setTitle("title2")
                .createTrack();
        Track track3 = new TrackBuilder()
                .setTitle("title3")
                .createTrack();
        CD cd = new CDBuilder()
                .setTitle("cd title")
                .setTrack(track1)
                .setTrack(track2)
                .setTrack(track3)
                .createCD();
        assertEquals("cd title", cd.getTitle());
        assertEquals(3, cd.getTracks().size());
        assertEquals("title1", cd.getTracks().get(0).getTitle());
        assertEquals("title2", cd.getTracks().get(1).getTitle());
        assertEquals("title3", cd.getTracks().get(2).getTitle());
    }


}