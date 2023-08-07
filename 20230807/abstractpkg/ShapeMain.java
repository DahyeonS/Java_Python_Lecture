package abstractpkg;

public class ShapeMain {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(10);
		shapes[1] = new Rectangle(5, 5);
		
		for (int i=0; i<shapes.length; i++) {
			System.out.println(shapes[i]);
			System.out.println(shapes[i].area());
			System.out.println(shapes[i].length());
		}
		
		for (Shape s : shapes) {
			System.out.println(s);
			System.out.println(s.area());
			System.out.println(s.length());
		}
	}

}
