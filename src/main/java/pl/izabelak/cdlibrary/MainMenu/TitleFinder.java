package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CDLibrary;
import pl.izabelak.cdlibrary.Track.Track;

import java.util.List;
import java.util.Scanner;

public class TitleFinder {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public TitleFinder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void findCD(){
        System.out.println("Wyszukiwanie plyty za pomoca tytulu:");
        System.out.println("Podaj tytul:");
        String title = scanner.nextLine();
        List<CD> byTitle = cdLibrary.findByTitle(title);
        System.out.println("Wyniki to:");
        CDDisplay.show(byTitle);
    }

    public void findTrack(){
        System.out.println("Wyszukiwanie utworu za pomoca tytulu:");
        System.out.println("Podaj tytul:");
        String title = scanner.nextLine();
        List<Track> trackByTitle = cdLibrary.findTrackByTitle(title);
        System.out.println("Wyniki to:");
        TrackDisplay.show(trackByTitle);
    }
}
