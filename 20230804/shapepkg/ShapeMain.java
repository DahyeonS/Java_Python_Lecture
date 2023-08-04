package shapepkg;

public class ShapeMain {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.draw(); // Circle center(0, 0) radius(5) draw!! 
		
//		Point p = new Point(5, 5);
//		Circle c2 = new Circle(p, 10);
//		c2.draw(); // Circle center(5, 5) radius(10) draw!! 
		
		Point p = new Point(5, 5);
		Circle c2 = new Circle(p, 10, "red");
		c2.draw(); // Circle center(3, 3) radius(5) color(red) draw!! 
		
		Triangle t1 = new Triangle();
		t1.draw();
		
		Point[] pp = new Point[3];
		pp[0] = new Point();
		pp[1] = new Point(3, 3);
		pp[2] = new Point(6, 6);
		String color = "blue";
		Triangle t2 = new Triangle(pp, color);
		t2.draw();
	}

}
