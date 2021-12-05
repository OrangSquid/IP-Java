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
        String[] boughtItemsNames = new String[nProducts];
        int[] boughtPrices = new int[nProducts];
        int boughtItems = 0;
        for(int i = 0; i < nProducts; i++) {
            if(cuppon >= productsPrices[i]) {
                cuppon -= productsPrices[i];
                boughtPrices[boughtItems] = productsPrices[i];
                boughtItemsNames[boughtItems] = productsNames[i];
                boughtItems++;
            }
        }
        for(int i = 0; i < boughtItems; i++) {
            for(int j = 0; j < boughtItems - i - 1; j++) {
                if(boughtPrices[j] < boughtPrices[j+1]) {
                    int temp = boughtPrices[j];
                    String tempString = boughtItemsNames[j];
                    boughtPrices[j] = boughtPrices[j+1];
                    boughtPrices[j+1] = temp;
                    boughtItemsNames[j] = boughtItemsNames[j+1];
                    boughtItemsNames[j+1] = tempString;
                } else if(boughtPrices[j] == boughtPrices[j+1] && boughtItemsNames[j].compareTo(boughtItemsNames[j+1]) > 0) {
                    String tempString = boughtItemsNames[j];
                    boughtItemsNames[j] = boughtItemsNames[j+1];
                    boughtItemsNames[j+1] = tempString;
                }
            }
        }
        for(int i = 0; i < boughtItems; i++) {
            System.out.println(boughtItemsNames[i]);
        }
        System.out.printf("%d %d\n", initialCuppon - cuppon, cuppon);
        sc.close();
    }
}