package pl.izabelak.cdlibrary.Track;

import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.TimeUtils;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Track {

    private String title;
    private String author;
    private Set<Genre> genres;
    private int time;

    public Track(String title, String author, Set <Genre> genres, int time) {
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Set <Genre> getGenres() {
        return genres;
    }

    public int getTime() {
        return time;
    }

    public String getGenresToString(){
         return genres.stream().map(Genre::getDecrip).collect(Collectors.joining(", "));
    }

    public String toString(){
        return "Title: " + title + ", "
                + "Author: " + author + ", "
                + "Genre: " + getGenresToString() + ", "
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
                Objects.equals(genres, track.genres);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, genres, time);
    }

}
