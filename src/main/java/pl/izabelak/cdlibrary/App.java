package pl.izabelak.cdlibrary;

import pl.izabelak.cdlibrary.MainMenu.CDDisplay;
import pl.izabelak.cdlibrary.MainMenu.CDReader;

import java.util.Scanner;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner sc = new Scanner(System.in);
    private CDReader newCD = new CDReader(cdLibrary, sc);

    public void showMainMenu() {
        cdLibrary.loadFromFile();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Show all authors");
            System.out.println("4. Find CDs by author");
            System.out.println("5. Exit");
            int action = Integer.parseInt(sc.nextLine());
            switch(action){
                case 1:
                    newCD.addNewCD();
                    break;
                case 2:
                    CDDisplay.show(cdLibrary.getCDs());
                    break;
                case 3:
                    cdLibrary.findAllAuthors();
                    break;
                case 4:
                    //
                case 5:
                    exit = true;
                    break;
                    default:
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
