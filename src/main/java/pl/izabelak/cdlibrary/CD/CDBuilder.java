package pl.izabelak.cdlibrary.CD;

import pl.izabelak.cdlibrary.Track.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CDBuilder {

    private UUID uuid;
    private String title;
    private String author;
    private int releaseYear;
    private String producer;
    private boolean isOriginal;
    private int discCount;
    private List<Track> tracks = new ArrayList<>();

    public CDBuilder setTitle (String title){
        this.title = title;
        return this;
    }

    public CDBuilder setAuthor (String author){
        this.author = author;
        return this;
    }

    public CDBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
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


    public CDBuilder setIsOriginal (boolean isOriginal){
        this.isOriginal = isOriginal;
        return this;
    }

    public CDBuilder setDiscCount (int discCount){
        this.discCount = discCount;
        return this;
    }

    public CDBuilder setTrack (Track track){
        if(this.tracks == null) {
            this.tracks =  new ArrayList<>();
        }
        tracks.add(track);
        return this;
    }

    public CDBuilder setTracks (List <Track> tracks){
        if(this.tracks == null) {
            this.tracks = tracks;
        } else {
            this.tracks.addAll(tracks);
        }
        return this;
    }

    public CD createCD (){
        return new CD (uuid, title, author, releaseYear, producer, isOriginal, discCount, tracks);
    }
}
