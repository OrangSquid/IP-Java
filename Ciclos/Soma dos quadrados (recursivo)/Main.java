import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double resultado = somar_quadrados(sc.nextInt());
        System.out.println(resultado);
        sc.close();
    }

    public static double somar_quadrados(int vezes) {
        if(vezes > 1) {
            return somar_quadrados(vezes - 1) + vezes * vezes;
        } else {
            return vezes * vezes;
        }
    }
}