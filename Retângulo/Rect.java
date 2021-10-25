package rectangle;

public class Rect {
	private double left;
	private double right;
	private double top;
	private double bottom;
	
	public Rect(double xMin, double yMax, double xMax, double yMin) {
		left = xMin;
		right = xMax;
		bottom = yMin;
		top = yMax;
	}
	
	public double getLeft() {
		return left;
	}
	
	public double getRight() {
		return right;
	}
	
	public double getTop() {
		return top;
	}
	
	public double getBottom() {
		return bottom;
	}
	
	public double getWidth() {
		return right - left;
	}
	
	public double getHeight() {
		return top - bottom;
	}
	
	public boolean isSquare() {
		return getWidth() == getHeight();
	}
	
	public double getPerimeter() {
		return 2 * (this.getHeight() + this.getWidth());
	}
	
	public Rect getHull(Rect other) {
		double yMin = Math.min(this.bottom, other.getBottom());
		double yMax = Math.max(this.top, other.getTop());
		double xMax = Math.max(this.right, other.getRight());
		double xMin = Math.min(this.left, other.getLeft());
		return new Rect(xMin, yMax, xMax, yMin);
	}

}
