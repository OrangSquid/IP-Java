import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int copy_b;
        while(b > 0) {
            copy_b = b;
            b = a % b;
            a = copy_b;
        }
        System.out.println(a);
        sc.close();
    }
}