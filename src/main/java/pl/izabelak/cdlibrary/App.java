package pl.izabelak.cdlibrary;

import pl.izabelak.cdlibrary.Track.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        cdLibrary.loadFromFile();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Exit");
            int action = Integer.parseInt(sc.nextLine());
            sc.nextLine();
            switch(action){
                case 1:
                    addNewCD();
                    break;
                case 2:
                    showAllCDs();
                    break;
                case 3:
                    exit = true;
                    break;
                    default:
                        continue;
            }
        }
        cdLibrary.saveToFile();
    }

    private void showAllCDs() {
    }


    public void addNewCD(){
        System.out.println("Adding new CD.");
        System.out.println("Write the title of the CD");
        String title = sc.nextLine();
        System.out.println("Write the author of the CD");
        String author = sc.nextLine();
        System.out.println("Write the year, when album was released");
        int releasedTime = Integer.parseInt(sc.nextLine());
        System.out.println("Write the producer of the album");
        String producer = sc.nextLine();
        System.out.println("Is the CD original? Press Y for yes and N for no.");
        boolean isOriginal = "Y".equals(sc.nextLine());
        System.out.println("How many disc has the album?");
        int discCount = Integer.parseInt(sc.nextLine());
        Genre genre = readGenre();
        List<Track> tracks = readTracks();

    }

    private List<Track> readTracks() {
        return new ArrayList<>();
    }

    private Genre readGenre() {
        return null;
    }

    public static void main(String[] args) {
        App app = new App();
        app.showMainMenu();
    }

}
