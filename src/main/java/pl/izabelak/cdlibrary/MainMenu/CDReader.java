package pl.izabelak.cdlibrary.MainMenu;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CD.CDBuilder;
import pl.izabelak.cdlibrary.CDLibrary;
import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import java.util.*;

public class CDReader {

    private CDLibrary cdLibrary;
    private Scanner sc;

    public CDReader(CDLibrary cdLibrary, Scanner sc) {
        this.cdLibrary = cdLibrary;
        this.sc = sc;
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
        List<Track> tracks = readTracks();
        CD cd = new CDBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setReleaseYear(releasedTime)
                .setProducer(producer)
                .setIsOriginal(isOriginal)
                .setDiscCount(discCount)
                .setTracks(tracks)
                .createCD();
        cdLibrary.add(cd);
    }

    private List<Track> readTracks() {
        System.out.println("How many tracks?");
        int count = Integer.parseInt(sc.nextLine());
        List <Track> tracks = new ArrayList<>();
        for(int i = 0; i < count; i++){
            tracks.add(readTrack());
        }
        return tracks;
    }

    private Track readTrack() {
        System.out.println("Adding new track:");
        System.out.println("Write the title of the track");
        String title = sc.nextLine();
        System.out.println("Write an author of this track");
        String author = sc.nextLine();
        System.out.println("Write the time of the track in seconds");
        int time = Integer.parseInt(sc.nextLine());
        Set <Genre> genres = readGenres();
        return new TrackBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setTime(time)
                .setGenres(genres)
                .createTrack();
    }

    private Set<Genre> readGenres() {
        Set<Genre> setOfGenres = new HashSet<>();
        System.out.println("How many genres has your track?");
        int genresCount = Integer.parseInt(sc.nextLine());
        for(int j = 0; j < genresCount; j++) {
            Genre[] genres = Genre.values();
            for (int i = 0; i < genres.length; i++) {
                System.out.println((i + 1) + " " + genres[i].getDecrip());
            }
            System.out.println("Choose number:");
            int number = Integer.parseInt(sc.nextLine());
            setOfGenres.add(genres[number - 1]);
        }
        return setOfGenres;
    }

}
