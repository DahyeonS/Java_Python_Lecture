package abstractpkg;

public class Rectangle extends Shape {
	int width, height;
	
	public Rectangle(int width, int height) {
		super("사각형");
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
		return String.format("Shape Type %s, width = %s, height = %s", type, width, height);
	}
}
