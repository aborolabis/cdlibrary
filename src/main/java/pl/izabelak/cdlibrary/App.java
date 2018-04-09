package pl.izabelak.cdlibrary;

import pl.izabelak.cdlibrary.MainMenu.*;

import java.util.Scanner;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner sc = new Scanner(System.in);
    private CDReader newCD = new CDReader(cdLibrary, sc);
    private ArtistFinder artistFinder = new ArtistFinder(cdLibrary, sc);
    private TitleFinder titleFinder = new TitleFinder(cdLibrary, sc);
    private GenreFinder genreFinder = new GenreFinder(cdLibrary, sc);

    public void showMainMenu() {
        cdLibrary.loadFromFile();
        boolean exit = false;
        while (!exit) {
            System.out.println();
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Show all authors");
            System.out.println("4. Find CDs by author");
            System.out.println("5. Find CDs by title");
            System.out.println("6. Find tracks by title");
            System.out.println("7. Find tracks by author");
            System.out.println("8. Find CDs by genre");
            System.out.println("9. Find Tracks by genre");
            System.out.println("0. Exit");
            int action = Integer.parseInt(sc.nextLine());
            switch(action){
                case 1:
                    newCD.addNewCD();
                    break;
                case 2:
                    CDDisplay.show(cdLibrary.getCDs());
                    break;
                case 3:
                    artistFinder.findAllAutors();
                    break;
                case 4:
                    artistFinder.findByArtist();
                    break;
                case 5:
                    titleFinder.findCD();
                    break;
                case 6:
                    titleFinder.findTrack();
                    break;
                case 7:
                    artistFinder.findTrackByAuthor();
                    break;
                case 8:
                    genreFinder.findCD();
                    break;
                case 9:
                    genreFinder.findTrack();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                        System.out.println("Incorrect answear - try again.");
                        continue;
            }
        }
        cdLibrary.saveToFile();
    }

    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}
