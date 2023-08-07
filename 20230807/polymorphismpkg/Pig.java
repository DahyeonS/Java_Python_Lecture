package polymorphismpkg;

public class Pig extends Animal implements Eats {

	@Override
	void info() {
		System.out.println("Pig - Animal");
	}

	@Override
	public void eats() {
		System.out.println("Pig - Eats");
	}
	
}
