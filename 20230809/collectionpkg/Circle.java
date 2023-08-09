package collectionpkg;

public class Circle extends Shape {
	double r;
	
	public Circle() {
		this(1);
	}

	public Circle(double r) {
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
		return String.format("Shape Cricle (%s, %s), r = %s", x, y, r);
	}
}
