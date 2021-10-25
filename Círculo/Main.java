import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x_cord = sc.nextDouble();
		double y_cord = sc.nextDouble();
		double radius = sc.nextDouble();
		Circle circle1 = new Circle(x_cord, y_cord, radius);
		sc.nextLine();
		
		String choice = sc.next();
		
		switch(choice) {
		case "P": // Perímetro
			System.out.printf("Perímetro: %.2f", circle1.calculatePerimeter());
			break;
		case "A": // Área
			System.out.printf("Área: %.2f", circle1.calculateArea());
			break;
		case "LP": // Ponto interior
			x_cord = sc.nextDouble();
			y_cord = sc.nextDouble();
			if(circle1.pointIsInCircle(x_cord, y_cord)) {
				System.out.println("O ponto pertence ao cícrulo");
			} else {
				System.out.println("O ponto não pertence ao círculo");
			}
			break;
		case "LC": // Relação entre círculos
			x_cord = sc.nextDouble();
			y_cord = sc.nextDouble();
			radius = sc.nextDouble();
			Circle circle2 = new Circle(x_cord, y_cord, radius);
			if(circle1.isInside(circle2)) {
				System.out.println("O primeiro círculo contém o segundo");
			}
			else if(circle1.circleIntersects(circle2)) {
				System.out.println("O primeiro círculo interseta uma parte do segundo");
			}
			else {
				System.out.println("O primeiro círculo não interseta o segundo");
			}
			break;
		}
		
		sc.close();

	}

}
