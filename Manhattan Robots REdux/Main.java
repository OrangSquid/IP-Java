import java.util.Scanner;

public class Main {
	public static final String MOVER = "MV";
	public static final String MUDAR_DIRECAO = "MD";
	public static final String PONTO_INTERESSE = "PI";
	public static final String LOCALIZACAO_ATUAL = "LP";
	public static final String DISTANCIA_PERCORRIDA = "LDT";
	public static final String DISTANCIA_PI = "LDPI";
	public static final String DISTANCIA_MAXIMA = "DTMAX";
	public static final String CLOSE_PROGRAM = "S";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cord_x1 = sc.nextInt();
		int cord_y1 = sc.nextInt();
		sc.nextLine();
		int cord_x2 = sc.nextInt();
		int cord_y2 = sc.nextInt();
		PostoDeVigia pdv = new PostoDeVigia(cord_x1, cord_y1, cord_x2, cord_y2);
		sc.nextLine();
		String command = "";
		boolean stop = false;
		
		while(!stop) {
			String output = null;
			int chosen_robot_number = 0;
			command = sc.next();

			switch(command) {
			case MOVER:
			case MUDAR_DIRECAO:
			case PONTO_INTERESSE:
			case LOCALIZACAO_ATUAL:
			case DISTANCIA_PERCORRIDA:
			case DISTANCIA_PI:
				chosen_robot_number = sc.nextInt();
				if(chosen_robot_number != 1 && chosen_robot_number != 2) {
					System.out.println("Robot invalido.");
					sc.nextLine();
					continue;
				}
				break;
			case DISTANCIA_MAXIMA:
			case CLOSE_PROGRAM:
				break;
			default:
				output = "Comando invalido.";
				break;
			}
			
			switch(command) {
			case MOVER:
				output = pdv.move(chosen_robot_number, sc.nextInt());
				break;
			case MUDAR_DIRECAO:
				output = pdv.changeOrientation(chosen_robot_number, sc.next());
				break;
			case PONTO_INTERESSE:
				pdv.markPI(chosen_robot_number);
				break;
			case LOCALIZACAO_ATUAL:
				output = pdv.currentLocation(chosen_robot_number);
				break;
			case DISTANCIA_PERCORRIDA:
				output = pdv.getWalkedDistance(chosen_robot_number);
				break;
			case DISTANCIA_PI:
				output = pdv.distanceToPI(chosen_robot_number);
				break;
			case DISTANCIA_MAXIMA:
				output = pdv.maxDistance();
				break;
			case CLOSE_PROGRAM:
				stop = true;
				break;
			}
			if(output != null) {
				System.out.println(output);
			}
			sc.nextLine();
		}

		sc.close();
	}

}
