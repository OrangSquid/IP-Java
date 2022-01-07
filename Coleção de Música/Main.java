import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlbumManager al = new AlbumManager();
        String command = "";

        while (!command.equals("SAIR")) {
            command = sc.nextLine();
            switch (command) {
                case "RA":
                    RACommand(al, sc);
                    break;
                case "CA":
                    CACommand(al, sc);
                    break;
                case "LC":
                    LCCommand(al);
                    break;
                case "LAA":
                    LAACommand(al, sc);
                    break;
                case "LCO":
                    LCOCommand(al);
                    break;
                case "LAO":
                    LAOCommand(al,sc);
                    break;
                case "AA":
                    AACommand(al, sc);
                    break;
                case "SAIR":
                    SAIRCommand(al);
                    break;
            }
        }
        sc.close();
    }

    private static void RACommand(AlbumManager al, Scanner sc) {
        al.addAlbum(sc.nextLine(), sc.nextLine(), sc.nextInt());
        sc.nextLine();
        System.out.println("Album inserido");
    }

    private static void CACommand(AlbumManager al, Scanner sc) {
        if (al.hasAlbum(sc.nextLine(), sc.nextLine())) {
            System.out.println("Album existente");
        } else {
            System.out.println("Album inexistente");
        }
    }

    private static void LCCommand(AlbumManager al) {
        AlbumIterator iterator = al.buyAlbumIterator();
        while(iterator.hasNext()) {
            Album album = iterator.next();
            System.out.printf("%s ; %s ; %s\n", album.getArtistName(), album.getName(), album.getYear());
        }
    }

    private static void LAACommand(AlbumManager al, Scanner sc) {
        FilteredAlbumIterator iterator = al.filteredBuyAlbumIterator(sc.nextLine());
        while(iterator.hasNext()) {
            Album album = iterator.next();
            System.out.printf("%s ; %s ; %s\n", album.getArtistName(), album.getName(), album.getYear());
        }
    }

    private static void LAOCommand(AlbumManager al, Scanner sc) {
        FilteredAlbumIterator iterator = al.filteredYearAlbumIterator(sc.nextLine());
        while(iterator.hasNext()) {
            Album album = iterator.next();
            System.out.printf("%s ; %s ; %s\n", album.getArtistName(), album.getName(), album.getYear());
        }
    }

    private static void AACommand(AlbumManager al, Scanner sc) {
        if (al.remove(sc.nextLine(), sc.nextLine())) {
            System.out.println("Album removido");
        }
    }

    private static void LCOCommand(AlbumManager al) {
        AlbumIterator iterator = al.yearAlbumIterator();
        while(iterator.hasNext()) {
            Album album = iterator.next();
            System.out.printf("%s ; %s ; %s\n", album.getArtistName(), album.getName(), album.getYear());
        }
    }

    private static void SAIRCommand(AlbumManager al) {
        System.out.printf("A colecao tem %d albuns\n", al.getSize());
    }
}