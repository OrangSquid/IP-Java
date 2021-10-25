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
		case "P": // Per�metro
			System.out.printf("Per�metro: %.2f", circle1.calculatePerimeter());
			break;
		case "A": // �rea
			System.out.printf("�rea: %.2f", circle1.calculateArea());
			break;
		case "LP": // Ponto interior
			x_cord = sc.nextDouble();
			y_cord = sc.nextDouble();
			if(circle1.pointIsInCircle(x_cord, y_cord)) {
				System.out.println("O ponto pertence ao c�crulo");
			} else {
				System.out.println("O ponto n�o pertence ao c�rculo");
			}
			break;
		case "LC": // Rela��o entre c�rculos
			x_cord = sc.nextDouble();
			y_cord = sc.nextDouble();
			radius = sc.nextDouble();
			Circle circle2 = new Circle(x_cord, y_cord, radius);
			if(circle1.isInside(circle2)) {
				System.out.println("O primeiro c�rculo cont�m o segundo");
			}
			else if(circle1.circleIntersects(circle2)) {
				System.out.println("O primeiro c�rculo interseta uma parte do segundo");
			}
			else {
				System.out.println("O primeiro c�rculo n�o interseta o segundo");
			}
			break;
		}
		
		sc.close();

	}

}
