import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nProducts = sc.nextInt();
        sc.nextLine();
        int[] productsPrices = new int[nProducts];
        String[] productsNames = new String[nProducts];
        for(int i = 0; i < nProducts; i++) {
            productsPrices[i] = sc.nextInt();
            sc.nextLine();
            productsNames[i] = sc.nextLine();
        }
        int initialCuppon = sc.nextInt();
        int cuppon = initialCuppon;
        String mostExpensiveName = "";
        int mostExpensivePrice = 0;
        for(int i = 0; i < nProducts; i++) {
            if(cuppon >= productsPrices[i]) {
                cuppon -= productsPrices[i];
                if(productsPrices[i] > mostExpensivePrice) {
                    mostExpensivePrice = productsPrices[i];
                    mostExpensiveName = productsNames[i];
                }
            }
        }
        if(!mostExpensiveName.equals("")) {
            System.out.println(mostExpensiveName);
        }
        System.out.printf("%d %d\n", initialCuppon - cuppon, cuppon);
        sc.close();
    }
}