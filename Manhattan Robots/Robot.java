
public class Robot {
	public static final String NORTH = "N";
	public static final String SOUTH = "S";
	public static final String EAST = "E";
	public static final String WEST = "O";
	
	private int cord_x;
	private int cord_y;
	private String orientation = NORTH;
	private int pi_cord_x;
	private int pi_cord_y;
	private int walked_distance = 0;
	
	public Robot(int cord_x, int cord_y) {
		this.cord_x = cord_x;
		this.cord_y = cord_y;
		this.pi_cord_x = cord_x;
		this.pi_cord_y = cord_y;
	}
	
	public void move(int distance) {
		switch(orientation) {
		case NORTH:
			cord_y += distance;
			break;
		case SOUTH:
			cord_y -= distance;
			break;
		case EAST:
			cord_x += distance;
			break;
		case WEST:
			cord_x -= distance;
			break;
		}
		walked_distance += Math.abs(distance);
	}
	
	public void changeOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	public void markPI() {
		cord_x = pi_cord_x;
		cord_y = pi_cord_y;
	}
	
	public String currentLocation() {
		return cord_x + " " + cord_y;
	}
	
	public int getWalkedDistance() {
		return walked_distance;
	}
	
	public int distanceToPI() {
		return Math.abs(cord_x - pi_cord_x) + Math.abs(cord_y - pi_cord_y);
	}

}
