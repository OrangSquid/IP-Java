import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        System.out.println(partir(n, m));
        sc.close();
    }

    public static int partir(int n, int m) {
        if(n == 0 && m >= 0) {
            return 1;
        } else if(n > 0 && m == 0) {    
            return 0;
        } else if(n < m && m > 0) {
            return partir(n, m - 1);
        } else if(n >= m && m > 0) {
            return partir(n - m, m) + partir(n, m - 1);
        }
        return 0;
    }
}