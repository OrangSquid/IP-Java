
public class AlbumManager {
    private Album[] albumsBuyOrder;
    private Album[] albumsYearOrder;
    private int size;

    public AlbumManager() {
        albumsBuyOrder = new Album[10];
        albumsYearOrder = new Album[10];
        size = 0;
    }

    public boolean isFull() {
        return size == albumsBuyOrder.length;
    }

    public void grow() {
        Album[] tmp = new Album[size * 2];
        Album[] tmp2 = new Album[size * 2];
        System.arraycopy(albumsBuyOrder, 0, tmp, 0, size);
        System.arraycopy(albumsYearOrder, 0, tmp2, 0, size);
        albumsBuyOrder = tmp;
        albumsYearOrder = tmp2;
    }

    public void addAlbum(String artistName, String name, int year) {
        if (isFull()) {
            grow();
        }
        Album tmpAlbum = new Album(name, artistName, year);
        albumsBuyOrder[size] = tmpAlbum;
        albumsYearOrder[size] = tmpAlbum;
        
        for (int i = size; i > 0; i--) {
            if (albumsYearOrder[i].getYear() < albumsYearOrder[i - 1].getYear()) {
                tmpAlbum = albumsYearOrder[i];
                albumsYearOrder[i] = albumsYearOrder[i - 1];
                albumsYearOrder[i - 1] = tmpAlbum;
            }
            else if (albumsYearOrder[i].getYear() == albumsYearOrder[i - 1].getYear()) {
                if (albumsYearOrder[i].getArtistName().toLowerCase().compareTo(albumsYearOrder[i - 1].getArtistName().toLowerCase()) < 0) {
                    tmpAlbum = albumsYearOrder[i];
                    albumsYearOrder[i] = albumsYearOrder[i - 1];
                    albumsYearOrder[i - 1] = tmpAlbum;
                }
                else if (albumsYearOrder[i].getArtistName().toLowerCase().compareTo(albumsYearOrder[i - 1].getArtistName().toLowerCase()) == 0) {
                    if (albumsYearOrder[i].getName().toLowerCase().compareTo(albumsYearOrder[i - 1].getName().toLowerCase()) < 0) {
                        tmpAlbum = albumsYearOrder[i];
                        albumsYearOrder[i] = albumsYearOrder[i - 1];
                        albumsYearOrder[i - 1] = tmpAlbum;
                    }
                }
            }
        }
        size++;
    }

    public AlbumIterator yearAlbumIterator() {
        return new AlbumIterator(albumsYearOrder, size);
    }

    public AlbumIterator buyAlbumIterator() {
        return new AlbumIterator(albumsBuyOrder, size);
    }

    public FilteredAlbumIterator filteredBuyAlbumIterator(String artistName) {
        return new FilteredAlbumIterator(albumsBuyOrder, size, artistName);
    }

    public FilteredAlbumIterator filteredYearAlbumIterator(String artistName) {
        return new FilteredAlbumIterator(albumsYearOrder, size, artistName);
    }

    public int getSize() {
        return size;
    }

    public boolean hasAlbum(String artistName, String name) {
        int i = 0;
        while (i < size && (!albumsBuyOrder[i].getArtistName().equals(artistName) || !albumsBuyOrder[i].getName().equals(name))) {
            i++;
        }
        return i != size;
    }

    public boolean remove(String artistName, String name) {
        int i = 0, j = 0;
        while (i < size && (!albumsBuyOrder[i].getArtistName().equals(artistName) || !albumsBuyOrder[i].getName().equals(name))) {
            i++;
        }
        while (j < size && (!albumsYearOrder[j].getArtistName().equals(artistName) || !albumsYearOrder[j].getName().equals(name))) {
            j++;
        }
        if (i != size) {
            size--;
            for (int k = i; k < size; k++) {
                albumsBuyOrder[k] = albumsBuyOrder[k + 1];
            }
            for (int l = j; l < size; l++) {
                albumsYearOrder[l] = albumsYearOrder[l + 1];
            }
            return true;
        } else {
            return false;
        }
    }
}