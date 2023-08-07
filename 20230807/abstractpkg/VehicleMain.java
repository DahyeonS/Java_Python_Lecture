package abstractpkg;

public class VehicleMain {
	public static void main(String[] args) {
		Car car = new Car();
		Ship ship = new Ship();
		Plane plane = new Plane();
		
		Vehicle vehicle1 = new Car();
		Vehicle vehicle2 = new Ship();
		Vehicle vehicle3 = new Plane();
		
		VehicleUse use = new VehicleUse();
		use.getMoveStyle(car);
		use.getMoveStyle(vehicle1);
		use.getMoveStyle(ship);
		use.getMoveStyle(vehicle2);
		use.getMoveStyle(plane);
		use.getMoveStyle(vehicle3);
	}
}
