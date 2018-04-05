package pl.izabelak.cdlibrary.CD;

import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;
import java.util.List;
import java.util.stream.Collectors;

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
