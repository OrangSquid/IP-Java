
public class Circle {
	private double x_cord;
	private double y_cord;
	private double radius;
	
	public Circle(double x_cord, double y_cord, double radius) {
		this.x_cord = x_cord;
		this.y_cord = y_cord;
		this.radius = radius;
	}
	
	public double getX() {
		return x_cord;
	}
	
	public double getY() {
		return y_cord;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public boolean pointIsInCircle(double x_cord, double y_cord) {
		return Math.sqrt(Math.pow((this.x_cord - x_cord), 2) + Math.pow((this.y_cord - y_cord), 2)) <= radius;
	}
	
	public boolean isInside(Circle other) {
		//     Distância entre os dois pontos de cada círculo, se for menor então o 2º círculo está dentro do primeiro
		return Math.sqrt(Math.pow((this.x_cord - other.getX()), 2) + Math.pow((this.y_cord - other.getY()), 2)) <= this.radius - other.getRadius();
	}
	
	public boolean circleIntersects(Circle other) {
		return Math.sqrt(Math.pow((this.x_cord - other.getX()), 2) + Math.pow((this.y_cord - other.getY()), 2)) <= this.radius + other.getRadius();
	}

}
