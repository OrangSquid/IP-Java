public class Album {
    private String name;
    private String artistName;
    private int year;

    public Album(String name, String artistName, int year) {
        this.name = name;
        this.artistName = artistName;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getYear() {
        return year;
    }
}
