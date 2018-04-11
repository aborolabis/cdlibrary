package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CDLibrary;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class UUIDFinder {

    private CDLibrary cdLibrary;
    private Scanner scanner;

    public UUIDFinder(CDLibrary cdLibrary, Scanner scanner) {
        this.cdLibrary = cdLibrary;
        this.scanner = scanner;
    }

    public void findCDByUUID(){
        System.out.println("Find a CD by his UUID:");
        System.out.println("Write the UUID:");
        UUID uuid = UUID.fromString(scanner.nextLine());
        Optional<CD> cdByUUID = cdLibrary.findCDByUUID(uuid);
        if(cdByUUID.isPresent()){
            System.out.println("Your CD is:");
            CD cd = cdByUUID.get();
            CDDisplay.show(cd);
        } else {
            System.out.println("Nothing to show...");
        }
    }
}
