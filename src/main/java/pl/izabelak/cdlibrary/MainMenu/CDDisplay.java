package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.CD.CD;

import java.util.List;

public class CDDisplay {

    public static void show(List<CD> listOfCDs){
        listOfCDs.forEach(System.out::println);
    }
}
