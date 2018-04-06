package pl.izabelak.cdlibrary;

import pl.izabelak.cdlibrary.CD.CD;
import pl.izabelak.cdlibrary.CD.CDBuilder;
import pl.izabelak.cdlibrary.Track.Track;
import pl.izabelak.cdlibrary.Track.TrackBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CDLibrary {

    private static final String FILENAME = "cdLibrary.txt";
    private List<CD> CDs = new ArrayList<>();

    public void add(CD cd){
        CDs.add(cd);
    }

    public void loadFromFile(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME));
            String line = bufferedReader.readLine();
            int count = Integer.parseInt(line);
            for(int i = 0; i < count; i++){
                loadCDFromFile(bufferedReader);
            }
        } catch (IOException ex){
            System.out.println("It cant be read. Try again later.");
        }

    }

    private void loadCDFromFile(BufferedReader bufferedReader) {
        try {
            String tittle = bufferedReader.readLine();
            String author = bufferedReader.readLine();
            int releasedYear = Integer.parseInt(bufferedReader.readLine());
            String producer = bufferedReader.readLine();
            Genre genre = Genre.valueOf(bufferedReader.readLine());
            boolean isOriginal = Boolean.valueOf(bufferedReader.readLine());
            int discCount = Integer.parseInt(bufferedReader.readLine());
            int count = Integer.parseInt(bufferedReader.readLine());
            List<Track> tracks = new ArrayList<>();
            for(int i = 0; i < count; i++){
                 Track track = loadTrackFromFile(bufferedReader);
                 tracks.add(track);
            }
            CD cd = new CDBuilder()
                    .setAuthor(author)
                    .setTitle(tittle)
                    .setReleaseYear(releasedYear)
                    .setProducer(producer)
                    .setGenre(genre)
                    .setIsOriginal(isOriginal)
                    .setDiscCount(discCount)
                    .setTracks(tracks)
                    .createCD();
            CDs.add(cd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Track loadTrackFromFile(BufferedReader bufferedReader) throws IOException {
        String title = bufferedReader.readLine();
        String author = bufferedReader.readLine();
        Genre genre = Genre.valueOf(bufferedReader.readLine());
        int time = Integer.valueOf(bufferedReader.readLine());

        Track track = new TrackBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setTime(time)
                .setGenre(genre)
                .createTrack();

        return track;
    }


    public void saveToFile(){
        try{
            PrintWriter out = new PrintWriter(FILENAME);
            out.println(CDs.size());
            for (CD cd : CDs){
                saveCDtoFile(out, cd);
            }
            out.close();
        } catch (FileNotFoundException ex){
            System.out.println("It didnt work. Try again later");
        }
    }

    private void saveCDtoFile(PrintWriter out, CD cd) {
        out.println(cd.getTitle());
        out.println(cd.getAuthor());
        out.println(cd.getReleaseYear());
        out.println(cd.getProducer());
        out.println(cd.getGenre());
        out.println(cd.isOriginal());
        out.println(cd.getDiscCount());
        List<Track> tracks = cd.getTracks();
        out.println(tracks.size());
        for (Track track : tracks) {
            saveTracktoFile(out, track);
        }
    }

    private void saveTracktoFile(PrintWriter out, Track track) {
        out.println(track.getTitle());
        out.println(track.getAuthor());
        out.println(track.getGenre());
        out.println(track.getTime());
    }

    public List <CD> getCDs(){
        return CDs;
    }

    public List <CD> findByAuthor(String author){
        String lowerCaseAuthor = author.toLowerCase();
        List<CD> foundByAuthor = CDs.stream().filter(cd -> cd.getAuthor().toLowerCase().contains(lowerCaseAuthor)).collect(Collectors.toList());
        return foundByAuthor;
    }

    public Set<String> findAllAuthors(){
        Set<String> allAuthors = CDs.stream().map(cd -> cd.getAuthor()).collect(Collectors.toSet());
        return allAuthors;
    }

    public List <CD> findByTitle(String title){
        String lowerCaseTitle = title.toLowerCase();
        List<CD> foundByTitle = CDs.stream().filter(cd -> cd.getTitle().toLowerCase().contains(title)).collect(Collectors.toList());
        return foundByTitle;
    }

    public List <CD> findByGenre(Genre genre){
        List<CD> foundByGenre = CDs.stream().filter(cd -> cd.getGenre().equals(genre)).collect(Collectors.toList());
        return foundByGenre;
    }

}
