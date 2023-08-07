package abstractpkg;

public class Circle extends Shape {
	int r;

	public Circle(int r) {
		super("원");
		this.r = r;
	}
	
	@Override
	double area() {
		return Math.PI * r * r;
	}
	
	@Override
	double length() {
		return 2 * Math.PI * r;
	}

	@Override
	public String toString() {
		return String.format("Shape Type %s, r = %s", type, r);
	}
}
