package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.Track.Track;

import java.util.List;

public class TrackDisplay {

    public static void show (List<Track> listOfTracks){
        listOfTracks.forEach(System.out::println);
    }

}
