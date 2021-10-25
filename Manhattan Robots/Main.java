import java.util.Scanner;

public class Main {
	public static final String MOVER = "MV";
	public static final String MUDAR_DIRECAO = "MD";
	public static final String PONTO_INTERESSE = "PI";
	public static final String LOCALIZACAO_ATUAL = "LP";
	public static final String DISTANCIA_PERCORRIDA = "LDT";
	public static final String DISTANCIA_PI = "LDPI";
	public static final String DISTANCIA_MAXIMA = "DTMAX";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cord_x = sc.nextInt();
		int cord_y = sc.nextInt();
		sc.nextLine();
		Robot robot1 = new Robot(cord_x, cord_y);
		cord_x = sc.nextInt();
		cord_y = sc.nextInt();
		Robot robot2 = new Robot(cord_x, cord_y);
		sc.nextLine();
		
		for(int i = 0; i < 5; i++) {
			String choice = sc.next();
			Robot chosen_robot = null;

			if(!choice.equals(DISTANCIA_MAXIMA)) {
				int chosen_robot_number = sc.nextInt();
				chosen_robot = chosen_robot_number == 1 ? robot1 : robot2;
			}
			
			switch(choice) {
			case MOVER:
				chosen_robot.move(sc.nextInt());
				break;
			case MUDAR_DIRECAO:
				chosen_robot.changeOrientation(sc.next());
				break;
			case PONTO_INTERESSE:
				chosen_robot.markPI();
				break;
			case LOCALIZACAO_ATUAL:
				System.out.println(chosen_robot.currentLocation());
				break;
			case DISTANCIA_PERCORRIDA:
				System.out.println(chosen_robot.getWalkedDistance());
				break;
			case DISTANCIA_PI:
				System.out.println(chosen_robot.distanceToPI());
				break;
			case DISTANCIA_MAXIMA:
				if(robot1.getWalkedDistance() == robot2.getWalkedDistance()) {
					System.out.println("EMPATE");
				}
				else if(robot1.getWalkedDistance() > robot2.getWalkedDistance()) {
					System.out.println("ROBOT 1");
				}
				else if(robot1.getWalkedDistance() < robot2.getWalkedDistance()) {
					System.out.println("ROBOT 2");
				}
				break;
			}
			sc.nextLine();
		}

		sc.close();
	}

}
