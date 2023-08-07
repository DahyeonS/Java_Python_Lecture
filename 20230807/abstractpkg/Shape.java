package abstractpkg;

public abstract class Shape {
	String type;
	
	public Shape(String type) {
		this.type = type;
	}
	
	abstract double area();
	abstract double length();
}
