package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.Track.Track;

import java.util.List;
import java.util.Set;

public class CDDisplay {

    public static void show(List<CD> listOfCDs){
        listOfCDs.forEach(System.out::println);
    }

    public static void show(CD cd){
        System.out.println(cd.toString());
    }
}
