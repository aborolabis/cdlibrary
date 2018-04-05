package pl.izabelak.cdlibrary;

import pl.izabelak.cdlibrary.CD.CD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CDLibrary {

    private List<CD> CDs = new ArrayList<>();

    public void add(CD cd){
        CDs.add(cd);
    }

    public void loadFromFile(){

    }

    public void saveToFile(){

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
