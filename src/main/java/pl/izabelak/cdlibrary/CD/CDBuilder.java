package pl.izabelak.cdlibrary.CD;

import pl.izabelak.cdlibrary.Genre;
import pl.izabelak.cdlibrary.Track.Track;

import java.util.ArrayList;
import java.util.List;

public class CDBuilder {

    private String title;
    private String author;
    private int releaseYear;
    private String producer;
    private Genre genre;
    private boolean isOriginal;
    private int discCount;
    private List<Track> tracks;

    public CDBuilder setTitle (String title){
        this.title = title;
        return this;
    }

    public CDBuilder setAuthor (String author){
        this.author = author;
        return this;
    }

    public CDBuilder setReleaseYear (int releaseYear){
        this.releaseYear = releaseYear;
        return this;
    }

    public CDBuilder setProducer (String producer){
        this.producer = producer;
        return this;
    }

    public CDBuilder setGenre (Genre genre){
        this.genre = genre;
        return this;
    }

    public CDBuilder setIsOriginal (boolean isOriginal){
        this.isOriginal = isOriginal;
        return this;
    }

    public CDBuilder setDiscCount (int discCount){
        this.discCount = discCount;
        return this;
    }

    public CDBuilder setTrack (Track track){
        if(tracks == null) {
            this.tracks =  new ArrayList<>();
        }
        tracks.add(track);
        return this;
    }

    public CDBuilder setTracks (List <Track> tracks){
        this.tracks = tracks;
        return this;
    }

    public CD createCD (){
        return new CD (title, author, releaseYear, producer, genre, isOriginal, discCount, tracks);
    }
}
