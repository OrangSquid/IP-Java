public class AlbumIterator {
    private Album[] albums;
    private int nAlbums;
    private int index;

    public AlbumIterator(Album[] albums, int nAlbums) {
        this.albums = albums;
        this.nAlbums = nAlbums;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < nAlbums;
    }

    public Album next() {
        return albums[index++];
    }
}