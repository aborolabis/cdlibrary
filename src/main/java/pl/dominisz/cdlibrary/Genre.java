package pl.dominisz.cdlibrary;

public enum Genre {

    ROCK ("rock"),
    POP ("pop"),
    METAL("metal"),
    BLUES("blues"),
    CLASSICAL("classical"),
    JAZZ("jazz"),
    COUNTRY("country"),
    DISCO("disco"),
    TECHNO("techno"),
    HIP_HOP("hip-hop"),
    SOUL("soul");

    private String decrip;

    Genre(String decrip) {
        this.decrip = decrip;
    }

    public String getDecrip() {
        return decrip;
    }
}
