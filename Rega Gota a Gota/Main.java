import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Incializar Culturas e Sistema de água
        String name1 = sc.nextLine();
        int min1 = sc.nextInt();
        sc.nextLine();
        int max1 = sc.nextInt();
        sc.nextLine();
        String name2 = sc.nextLine();
        int min2 = sc.nextInt();
        sc.nextLine();
        int max2 = sc.nextInt();
        sc.nextLine();
        WaterSystem ws = new WaterSystem(name1, min1, max1, name2, min2, max2);

        // Criar o registo para cada dia
        int days = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < days; i++) {
            ws.registerDay(sc.nextLine());
        }
        
        System.out.println(ws.getBestDaysBotht() + " dias adequados para ambas");
        if(ws.isEquivalent()) {
        	System.out.println("Opções equivalentes");
        } else {
        	System.out.println("Opte por " + ws.bestCrop());
        }
        
        sc.close();
    }
}