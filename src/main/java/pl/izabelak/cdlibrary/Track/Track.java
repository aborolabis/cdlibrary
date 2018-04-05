package pl.izabelak.cdlibrary.Track;

import pl.izabelak.cdlibrary.Genre;

public class Track {

    private String title;
    private String author;
    private Genre genre;
    private int time;

    public Track(String title, String author, Genre genre, int time) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getTime() {
        return time;
    }
}
