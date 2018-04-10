package pl.izabelak.cdlibrary;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CD.CDBuilder;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CDLibraryTest {

    CDLibrary cdLibrary = new CDLibrary();
    String testTrack1 = "title1;horse;120;JAZZ";
    String testTrack2 = "title2;horse;160;JAZZ";
    String testTrack3 = "minnie;mickey;210;POP";
    String testTrack4 = "donald;mickey;120;POP";

    String testCD1 = "original title;horse;producer;JAZZ;true;2001;1";
    String testCD2 = "pack of animals;mickey;producer;POP;false;2011;1";

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
                .setTitle(splitedTestString[0])
                .setAuthor(splitedTestString[1])
                .setProducer(splitedTestString[2])
                .setGenre(Genre.valueOf(splitedTestString[3]))
                .setIsOriginal(Boolean.valueOf(splitedTestString[4]))
                .setReleaseYear(Integer.parseInt(splitedTestString[5]))
                .setDiscCount(Integer.parseInt(splitedTestString[6]))
                .createCD();
        return cd;
    }

    Track createTrack(String testTrack) {
        String[] splitedTestTrack = testTrack.split(";");
        Track track = new TrackBuilder()
                .setTitle(splitedTestTrack[0])
                .setAuthor(splitedTestTrack[1])
                .setTime(Integer.valueOf(splitedTestTrack[2]))
                .setGenre(Genre.valueOf(splitedTestTrack[3]))
                .createTrack();
        return track;
    }

    @Test
    public void testFindCDByGenreExisting() {
        Genre genre = Genre.JAZZ;
        List<CD> cdByGenre = cdLibrary.findCDByGenre(genre);

        assertEquals(1, cdByGenre.size());
        assertEquals(genre, cdByGenre.get(0).getGenre());
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
        assertEquals(genre, tracksByGenre.get(0).getGenre());
        assertEquals(genre, tracksByGenre.get(1).getGenre());
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
    public void testLoadFromFile(){
        CDLibrary libraryFromFile = new CDLibrary();
        String file = this.getClass().getResource("/testLibrary.txt").getPath();
        libraryFromFile.loadFromFile(file);

        assertEquals(cdLibrary.getCDs().size(), libraryFromFile.getCDs().size());
        for(int i = 0; i < cdLibrary.getCDs().size(); i++){
            assertEquals(cdLibrary.getCDs().get(i), libraryFromFile.getCDs().get(i));
            assertEquals(cdLibrary.getCDs().get(i).getTracks().size(), libraryFromFile.getCDs().get(i).getTracks().size());
            for(int j = 0; j < cdLibrary.getCDs().get(i).getTracks().size(); j++){
                assertEquals(cdLibrary.getCDs().get(i).getTracks().get(j), libraryFromFile.getCDs().get(i).getTracks().get(j));
            }
        }
    }

    @Test void testSaveToFile() throws IOException {
        String savedLibrary = this.getClass().getResource("/").getPath();
        cdLibrary.saveToFile(savedLibrary + "savedLibrary.txt");
        File savedFile = new File(savedLibrary + "savedLibrary.txt");
        
        String testLibrary = this.getClass().getResource("/testLibrary.txt").getPath();
        File testFile = new File(testLibrary);

        FileUtils.contentEquals(savedFile, testFile);

    }




}
