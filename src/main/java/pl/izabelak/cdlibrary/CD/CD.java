package pl.izabelak.cdlibrary.CD;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.TimeUtils;
import pl.izabelak.cdlibrary.Track.Track;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CD {

    private UUID uuid;
    private String title;
    private String author;
    private int releaseYear;
    private String producer;
    private boolean isOriginal;
    private int discCount;
    private List<Track> tracks;

    public CD(UUID uuid, String title, String author, int releaseYear, String producer, boolean isOriginal, int discCount, List<Track> tracks) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.producer = producer;
        this.isOriginal = isOriginal;
        this.discCount = discCount;
        this.tracks = tracks;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getTotalTime(){
        int totalTime = 0;
        if(tracks != null){
            for(int i = 0; i < tracks.size(); i++){
                totalTime = totalTime + tracks.get(i).getTime();
            }
        }
        return totalTime;
    }

    public int getTotalTimeStream(){
        if(tracks != null) {
            return tracks.stream().mapToInt(Track::getTime).sum();
        } else {
            return 0;
        }
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

    public Set <Genre> getGenres() {
        if(tracks != null) {
            return tracks.stream().flatMap(track -> track.getGenres().stream()).collect(Collectors.toSet());
        } else {
            return null;
        }
    }

    public boolean isOriginal() {
        return isOriginal;
    }

    public String isOriginalToString(){
        if(isOriginal){
            return "CD is original";
        } else {
            return "CD is not original";
        }
    }

    public int getDiscCount() {
        return discCount;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public String toString(){
        String text = "UUID: " + uuid + "\n"
                + "Title: " + title + "\n"
                + "Author: " + author + "\n"
                + "Released Year: " + releaseYear + "\n"
                + "Producer: " + producer + "\n"
                + isOriginalToString() + "\n"
                + "Disc Count: " + discCount + "\n"
                + "Time: " + TimeUtils.getTimeToString(getTotalTime()) + "\n"
                + "Genres: " + "\n";
        for(int i = 0; i < tracks.size(); i++){
            text = text + tracks.get(i).getGenresToString() + ", ";
        }
                text = text + "\n" + "Tracks: ";
        for(int i = 0; i < tracks.size(); i ++){
            text = text + "\n" + (i+1) + ". " + tracks.get(i).toString();
        }
        text = text + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return releaseYear == cd.releaseYear &&
                isOriginal == cd.isOriginal &&
                discCount == cd.discCount &&
                Objects.equals(title, cd.title) &&
                Objects.equals(author, cd.author) &&
                Objects.equals(producer, cd.producer) &&
                Objects.equals(tracks, cd.tracks) &&
                uuid.equals(cd.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, releaseYear, producer, isOriginal, discCount, tracks, uuid);
    }
}
