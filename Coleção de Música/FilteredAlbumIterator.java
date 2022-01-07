public class FilteredAlbumIterator {
    private Album[] albums;
    private int nAlbums;
    private int index;
    private String artistName;

    public FilteredAlbumIterator(Album[] albums, int nAlbums, String artistName) {
        this.albums = albums;
        this.nAlbums = nAlbums;
        this.index = 0;
        this.artistName = artistName;
        advance();
    }

    public boolean hasNext() {
        return index < nAlbums;
    }

    private void advance() {
        while(index < nAlbums && !albums[index].getArtistName().equals(artistName)) {
            index++;
        }
    }

    public Album next() {
        Album tmpAlbum = albums[index++];
        advance();
        return tmpAlbum;
    }
}