package shapepkg;

public class Triangle extends Shape {
	Point[] p;
	
	public Triangle() {
		super("black");
		Point[] pp = new Point[3];
		pp[0] = new Point(); // (0, 0)
		pp[1] = new Point(5, 5);
		pp[2] = new Point(-5, -5);
		this.p = pp;
	}
	
	public Triangle(Point[] p, String color) {
		super(color);
		this.p = p;
	}
	
	@Override
	void draw() {
		Point p1 = this.p[0];
		Point p2 = this.p[1];
		Point p3 = this.p[2];
		String s = "Triangle p1(%s), p2(%s), p3(%s), color(%s) draw!! \n";
		System.out.printf(s, p1.getXY(), p2.getXY(), p3.getXY(), color);
	}
}
