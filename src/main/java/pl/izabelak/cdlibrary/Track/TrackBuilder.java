package pl.izabelak.cdlibrary.Track;

// PRZYKLAD BUILDERA !!!!
// Pola te same, konstruktor pusty, metody set zwracające typ klasy Buildera, przez co parametr wpisany jest do klasy (return).
// Następnie ostatnia metoda - tworzenie tracka.

import pl.izabelak.cdlibrary.Genre;

import java.util.HashSet;
import java.util.Set;

public class TrackBuilder {

    private String title;
    private String author;
    private Set<Genre> genres;
    private int time;

    public TrackBuilder() {
    }

    public TrackBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public TrackBuilder setAuthor(String author){
        this.author = author;
        return this;
    }

    public TrackBuilder setGenres(Set <Genre> genres){
        this.genres = genres;
        return this;
    }

    public TrackBuilder setGenre (Genre genre) {
        if (this.genres == null) {
            this.genres = new HashSet<>();
        }
        this.genres.add(genre);
        return this;
    }

    public TrackBuilder setTime (int time){
        this.time = time;
        return this;
    }

    public Track createTrack() {
        return new Track (title, author, genres, time);
    }
}
