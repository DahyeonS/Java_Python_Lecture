package collectionpkg;

public abstract class Shape {
	int x, y;
	
	public Shape() {
		this(0, 0);
	}
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract double area();
	abstract double length();
	
	public String getLocation() {
		return "x: " + x + ", y: " + y;
	}
}
