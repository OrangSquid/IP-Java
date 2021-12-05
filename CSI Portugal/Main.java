import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = sc.nextInt(); i > 0; i--) {
            sc.nextLine();
            int first_hour_crime = sc.nextInt();
            int last_hour_crime = sc.nextInt();
            sc.nextLine();
            int first_hour_suspect = sc.nextInt();
            int last_hour_suspect = sc.nextInt();
            if(first_hour_crime >= first_hour_suspect && last_hour_crime <= last_hour_suspect) {
                System.out.println("Com Alibi");
            } else {
                System.out.println("Sem Alibi");
            }
        }
        sc.close();
    }
}
