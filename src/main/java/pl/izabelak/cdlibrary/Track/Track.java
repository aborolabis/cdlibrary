package pl.izabelak.cdlibrary.Track;

import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.TimeUtils;

import java.util.Objects;

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

    public String toString(){
        return "Title: " + title + ", "
                + "Author: " + author + ", "
                + "Genre: " + genre.getDecrip() + ", "
                + "Time: " + TimeUtils.getTimeToString(time) + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return time == track.time &&
                Objects.equals(title, track.title) &&
                Objects.equals(author, track.author) &&
                genre == track.genre;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, genre, time);
    }

}
