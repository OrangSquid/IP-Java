import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first_hour_crime = sc.nextInt();
        int last_hour_crime = sc.nextInt();
        sc.nextLine();
        int first_hour_suspect = sc.nextInt();
        int last_hour_suspect = sc.nextInt();
        if (first_hour_crime >= first_hour_suspect && last_hour_crime <= last_hour_suspect) {
            System.out.println("Com Alibi");
        }
        // A atividade está contida no intervalo do crime
        else if (first_hour_crime <= first_hour_suspect && last_hour_crime >= last_hour_suspect) {
            System.out.println("Sem Alibi");
            System.out.println(first_hour_suspect - first_hour_crime + last_hour_crime - last_hour_suspect);
        }
        // A atividade está fora do intervalo do crime
        else {
            System.out.println("Sem Alibi");
            System.out.println(last_hour_crime - first_hour_crime);
        }
        sc.close();
    }
}
