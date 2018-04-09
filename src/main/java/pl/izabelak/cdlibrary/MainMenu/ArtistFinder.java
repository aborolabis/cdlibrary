package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CDLibrary;
import pl.izabelak.cdlibrary.MainMenu.CDDisplay;
import pl.izabelak.cdlibrary.Track.Track;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ArtistFinder {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public ArtistFinder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void findByArtist(){
        System.out.println("Wyszukiwanie plyty za pomoca artysty:");
        System.out.println("Podaj nazwe artysty:");
        String author = scanner.nextLine();
        List<CD> byAuthor = cdLibrary.findByAuthor(author);
        System.out.println("Wyniki to:");
        CDDisplay.show(byAuthor);
    }

    public void findAllAutors(){
        System.out.println("Wszyscy wykonawcy to:");
        Set<String> allAuthors = cdLibrary.findAllAuthors();
        allAuthors.forEach(author -> System.out.println("- " + author));
        System.out.println();
    }

    public void findTrackByAuthor() {
        System.out.println("Wyszukiwanie piosenek po wykonawcy:");
        System.out.println("Podaj nazwe artysty:");
        String author = scanner.nextLine();
        List<Track> trackByAuthors = cdLibrary.findTrackByAuthors(author);
        TrackDisplay.show(trackByAuthors);
    }
}
