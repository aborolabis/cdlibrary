package pl.dominisz.cdlibrary;

// PRZYKLAD BUILDERA !!!!
// Pola te same, konstruktor pusty, metody set zwracające typ klasy Buildera, przez co parametr wpisany jest do klasy (return).
// Następnie ostatnia metoda - tworzenie tracka.

public class TrackBuilder {

    private String title;
    private String author;
    private Genre genre;
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

    public TrackBuilder setGenre(Genre genre){
        this.genre = genre;
        return this;
    }

    public TrackBuilder setTime (int time){
        this.time = time;
        return this;
    }

    public Track createTrack() {
        return new Track (title, author, genre, time);
    }
}
