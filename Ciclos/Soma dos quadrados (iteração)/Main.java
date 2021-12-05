import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vezes = sc.nextInt();
        int resultado = 0;

        for(int i = 1; i <= vezes; i++) {
            resultado += i * i;
        }
        System.out.println(resultado);
        sc.close();
    }
}