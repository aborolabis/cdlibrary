package pl.izabelak.cdlibrary.CD;

import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;
import java.util.List;

public class CD {

    private String title;
    private String author;
    private int releaseYear;
    private String producer;
    private Genre genre;
    private boolean isOriginal;
    private int discCount;
    private List<Track> tracks;

    public CD(String title, String author, int releaseYear, String producer, Genre genre, boolean isOriginal, int discCount, List<Track> tracks) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.producer = producer;
        this.genre = genre;
        this.isOriginal = isOriginal;
        this.discCount = discCount;
        this.tracks = tracks;
    }

    public int getTotalTime(){
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getProducer() {
        return producer;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isOriginal() {
        return isOriginal;
    }

    public int getDiscCount() {
        return discCount;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
