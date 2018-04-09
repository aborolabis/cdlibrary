package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CDLibrary;
import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;

import java.util.List;
import java.util.Scanner;

public class GenreFinder {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public GenreFinder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    private Genre getGenre() {
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + " " + genres[i].getDecrip());
        }
        System.out.println("Wybierz numer:");
        int number = Integer.parseInt(scanner.nextLine());
        return genres[number - 1];
    }

    public void findCD(){
        System.out.println("Wyszukiwanie plyt za pomocą gatunku:");
        System.out.println("Wybierz gatunek:");
        Genre genre = getGenre();
        List<CD> cdByGenre = cdLibrary.findCDByGenre(genre);
        System.out.println("Wyniki to:");
        CDDisplay.show(cdByGenre);
    }

    public void findTrack(){
        System.out.println("Wyszukiwanie utworow za pomocą gatunku:");
        System.out.println("Wybierz gatunek:");
        Genre genre = getGenre();
        List<Track> TrackByGenre = cdLibrary.findTracksByGenre(genre);
        System.out.println("Wyniki to:");
        TrackDisplay.show(TrackByGenre);
    }



}
