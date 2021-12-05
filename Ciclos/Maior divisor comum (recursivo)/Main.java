import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resultado = gcdRec(sc.nextInt(), sc.nextInt());
        System.out.println(resultado);
        sc.close();
    }

    public static int gcdRec(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcdRec(b, a % b);
    }
}