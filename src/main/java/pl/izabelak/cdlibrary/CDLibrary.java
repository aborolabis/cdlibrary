package pl.izabelak.cdlibrary;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.Track.Track;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CDLibrary {

    private static final String FILENAME = "cdLibrary.txt";
    private List<CD> CDs = new ArrayList<>();

    public void add(CD cd){
        CDs.add(cd);
    }

    public void loadFromFile(){

    }

    public void saveToFile(){
        try{
            PrintWriter out = new PrintWriter(FILENAME);
            out.println(CDs.size());
            for (CD cd : CDs){
                saveCDtoFile(out, cd);
            }
            out.close();
        } catch (FileNotFoundException ex){
            System.out.println("It didnt work. Try again later");
        }
    }

    private void saveCDtoFile(PrintWriter out, CD cd) {
        out.println(cd.getTitle());
        out.println(cd.getAuthor());
        out.println(cd.getReleaseYear());
        out.println(cd.getProducer());
        out.println(cd.getGenre());
        out.println(cd.isOriginal());
        out.println(cd.getDiscCount());
        List<Track> tracks = cd.getTracks();
        out.println(tracks.size());
        for (Track track : tracks) {
            saveTracktoFile(out, track);
        }
    }

    private void saveTracktoFile(PrintWriter out, Track track) {
        out.println(track.getTitle());
        out.println(track.getAuthor());
        out.println(track.getGenre());
        out.println(track.getTime());
    }

    public List <CD> getCDs(){
        return CDs;
    }

    public List <CD> findByAuthor(String author){
        return new ArrayList<>();
    }

    public List <CD> findByTitle(String title){
        return new ArrayList<>();
    }

    public List <CD> findByGenre(Genre genre){
        return new ArrayList<>();
    }

}
