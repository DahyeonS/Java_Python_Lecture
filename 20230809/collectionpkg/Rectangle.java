package collectionpkg;

public class Rectangle extends Shape {
	int width, height;
	
	public Rectangle() {
		this(1, 1);
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	double area() {
		return width * height;
	}
	
	@Override
	double length() {
		return 2 * (width + height);
	}
	
	@Override
	public String toString() {
		return String.format("Shape Rectangle (%s, %s), width = %s, height = %s", x, y, width, height);
	}
}
