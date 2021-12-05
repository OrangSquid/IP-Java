import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nGuesses = sc.nextInt();
        int[] leigo = new int[nGuesses];
        int[] telepata = new int[nGuesses];
        for(int i = 0; i < nGuesses; i++) {
            leigo[i] = sc.nextInt();
        }
        sc.nextLine();
        for(int i = 0; i < nGuesses; i++) {
            telepata[i] = sc.nextInt();
        }
        int correctGuesses = 0;
        int points = 0;
        boolean firstConsecutive = false;
        boolean moreConsecutive = false;
        for(int i = 0; i < nGuesses; i++) {
            if(leigo[i] == telepata[i]) {
                if(moreConsecutive) {
                    points += 3;
                }
                else if(firstConsecutive) {
                    points += 5;
                    moreConsecutive = true;
                } else {
                    points++;
                    firstConsecutive = true;
                }
                correctGuesses++;
            } else {
                moreConsecutive = false;
                firstConsecutive = false;
            }
        }
        System.out.println(correctGuesses);
        System.out.println(points);
        sc.close();
    }
}