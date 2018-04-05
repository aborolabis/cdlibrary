package pl.izabelak.cdlibrary;

/**
 * http://dominisz.pl
 * 25.03.2018
 */
public class App {

    public static void main(String[] args) {
        CDLibrary cdLibrary;
        cdLibrary = new CDLibrary();
        cdLibrary.loadFromFile();
        cdLibrary.showMainMenu();
        cdLibrary.saveToFile();
    }

}
