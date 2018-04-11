package pl.izabelak.cdlibrary;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CD.CDBuilder;
import pl.izabelak.cdlibrary.MainMenu.UUIDFinder;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CDLibraryTest {

    CDLibrary cdLibrary = new CDLibrary();
    String testTrack1 = "title1;horse;120;2;JAZZ;POP";
    String testTrack2 = "title2;horse;160;2;JAZZ;METAL";
    String testTrack3 = "minnie;mickey;210;2;SOUL;POP";
    String testTrack4 = "donald;mickey;120;2;SOUL;POP";

    String testCD1 = "58e82453-4371-4965-8896-233fb3099bba;original title;horse;producer;true;2001;1";
    String testCD2 = "5562625a-3da0-11e8-b467-0ed5f89f718b;pack of animals;mickey;producer;false;2011;1";

    @BeforeEach
    void setup() {
        CD cd1 = createCD(testCD1);
        CD cd2 = createCD(testCD2);

        cd1.getTracks().add(createTrack(testTrack1));
        cd1.getTracks().add(createTrack(testTrack2));

        cd2.getTracks().add(createTrack(testTrack3));
        cd2.getTracks().add(createTrack(testTrack4));

        cdLibrary.add(cd1);
        cdLibrary.add(cd2);
    }

    CD createCD(String testCD) {
        String[] splitedTestString = testCD.split(";");
        CD cd = new CDBuilder()
                .setUuid(UUID.fromString(splitedTestString[0]))
                .setTitle(splitedTestString[1])
                .setAuthor(splitedTestString[2])
                .setProducer(splitedTestString[3])
                .setIsOriginal(Boolean.valueOf(splitedTestString[4]))
                .setReleaseYear(Integer.parseInt(splitedTestString[5]))
                .setDiscCount(Integer.parseInt(splitedTestString[6]))
                .createCD();
        return cd;
    }

    Track createTrack(String testTrack) {
        String[] splitedTestTrack = testTrack.split(";");
        Set <Genre> genres = new HashSet<>();
        for(int i = 0; i < Integer.valueOf(splitedTestTrack[3]); i++){
            genres.add(Genre.valueOf(splitedTestTrack[i+4]));
        }
        Track track = new TrackBuilder()
                .setTitle(splitedTestTrack[0])
                .setAuthor(splitedTestTrack[1])
                .setTime(Integer.valueOf(splitedTestTrack[2]))
                .setGenres(genres)
                .createTrack();
        return track;
    }

    @Test
    public void testFindCDByGenreExisting() {
        Genre genre = Genre.JAZZ;
        List<CD> cdByGenre = cdLibrary.findCDByGenre(genre);

        assertEquals(1, cdByGenre.size());
        assertTrue(cdByGenre.get(0).getGenres().contains(genre));
    }

    @Test
    public void testFindCDByGenreNotExisting() {
        Genre genre = Genre.HIP_HOP;
        List<CD> cdByGenre = cdLibrary.findCDByGenre(genre);

        assertEquals(0, cdByGenre.size());
    }

    @Test
    public void testFindTrackByGenreExisting() {
        Genre genre = Genre.JAZZ;
        List<Track> tracksByGenre = cdLibrary.findTracksByGenre(genre);

        assertEquals(2, tracksByGenre.size());
        assertTrue(tracksByGenre.get(0).getGenres().contains(genre));
        assertTrue(tracksByGenre.get(1).getGenres().contains(genre));
    }

    @Test
    public void testFindTrackByGenreNotExisting() {
        Genre genre = Genre.HIP_HOP;
        List<Track> cdByGenre = cdLibrary.findTracksByGenre(genre);

        assertEquals(0, cdByGenre.size());
    }

    @Test
    public void testFindTrackByTitleExisting() {
        String title = "minnie";
        List<Track> trackByTitle = cdLibrary.findTrackByTitle(title);

        assertEquals(1, trackByTitle.size());
        assertEquals(title, trackByTitle.get(0).getTitle());
    }

    @Test
    public void testFindTrackByTitleNotExisting() {
        String title = "oko";
        List<Track> trackByTitle = cdLibrary.findTrackByTitle(title);

        assertEquals(0, trackByTitle.size());
    }

    @Test
    public void testFindTrackByAuthorsExisting() {
        String author = "mickey";
        List<Track> trackByAuthors = cdLibrary.findTrackByAuthors(author);

        assertEquals(2, trackByAuthors.size());
        assertEquals(author, trackByAuthors.get(0).getAuthor());
        assertEquals(author, trackByAuthors.get(1).getAuthor());
    }

    @Test
    public void testFindTrackByAuthorsNotExisting() {
        String author = "cat";
        List<Track> trackByAuthors = cdLibrary.findTrackByAuthors(author);

        assertEquals(0, trackByAuthors.size());
    }

    @Test
    public void testFindCDByTrackTitleExisting() {
        String title = "donald";
        List<CD> cdByTrackTitle = cdLibrary.findCDByTrackTitle(title);

        assertEquals(1, cdByTrackTitle.size());
        assertEquals(title, cdByTrackTitle.get(0).getTracks().get(1).getTitle());
    }

    @Test
    public void testFindCDByTrackTitleNotExisting() {
        String title = "pluto";
        List<CD> cdByTrackTitle = cdLibrary.findCDByTrackTitle(title);

        assertEquals(0, cdByTrackTitle.size());
    }

    @Test
    public void testFindCDByTitleExisting(){
        String title = "pack of animals";
        List<CD> byTitle = cdLibrary.findByTitle(title);

        assertEquals(1, byTitle.size());
        assertEquals(title, byTitle.get(0).getTitle());
    }

    @Test
    public void testFindCDByTitleNotExisting(){
        String title = "horsay";
        List<CD> byTitle = cdLibrary.findByTitle(title);

        assertEquals(0, byTitle.size());
    }

    @Test
    public void testFindAllArtist(){

        Set<String> allAuthors = cdLibrary.findAllAuthors();

        assertEquals(2, allAuthors.size());
    }

    @Test
    public void testFindByAuthors(){
        String author = "mickey";
        List<CD> byAuthor = cdLibrary.findByAuthor(author);

        assertEquals(1, byAuthor.size());
        assertEquals(author, byAuthor.get(0).getAuthor());
    }


    @Test
    public void testLoadFromFile() {
        CDLibrary libraryFromFile = new CDLibrary();
        String path = this.getClass().getResource("/testlibrary.txt").getPath();
        libraryFromFile.loadFromFile(path);
        assertEquals(cdLibrary.getCDs().size(), libraryFromFile.getCDs().size());
        for (int i = 0; i < cdLibrary.getCDs().size(); i++) {
            assertEquals(cdLibrary.getCDs().get(i), libraryFromFile.getCDs().get(i));
        }
    }

    @Test
    void testSaveToFile() throws IOException {
        String savedLibrary = this.getClass().getResource("/").getPath();
        cdLibrary.saveToFile(savedLibrary + "savedLibrary.txt");
        File savedFile = new File(savedLibrary + "savedLibrary.txt");

        String testLibrary = this.getClass().getResource("/testLibrary.txt").getPath();
        File testFile = new File(testLibrary);

        FileUtils.contentEquals(savedFile, testFile);
    }

    @Test
    void testAddCD(){
        CDLibrary testCDLibrary = new CDLibrary();
        assertTrue(testCDLibrary.getCDs().isEmpty());
        CD cd = createCD(testCD1);
        testCDLibrary.add(cd);


        assertEquals(1, testCDLibrary.getCDs().size());
        assertEquals(cd, testCDLibrary.getCDs().get(0));
    }

    @Test
    void shouldFindOneCDByUUID(){
        UUID uuid = UUID.fromString("58e82453-4371-4965-8896-233fb3099bba");
        Optional<CD> cdByUUID = cdLibrary.findCDByUUID(uuid);

        assertTrue(cdByUUID.isPresent());
        assertEquals(uuid, cdByUUID.get().getUuid());
    }

    @Test
    void shouldFindNoneCDBYUUID(){
        UUID uuid = UUID.randomUUID();
        Optional<CD> cdByUUID = cdLibrary.findCDByUUID(uuid);

        assertFalse(cdByUUID.isPresent());
    }




}
