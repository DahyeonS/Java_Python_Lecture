package shapepkg;

public class Circle extends Shape {
	private Point center;
	private int r;
	
	public Circle() {
		this(new Point(), 5, "black");
	}
	
	public Circle(Point center, int r, String color) {
		super(color);
		this.center = center;
		this.r = r;	}
	
	@Override
	void draw() {
		String s = "Circle center(%s) radius(%s) color(%s) draw!! \n";
		System.out.printf(s, center.getXY(), this.r, color);
	}
}
