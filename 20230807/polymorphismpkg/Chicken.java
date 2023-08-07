package polymorphismpkg;

public class Chicken extends Animal implements Birds, Eats{

	@Override
	void info() {
		System.out.println("Chicken - Animal");
	}

	@Override
	public void birds() {
		System.out.println("Chicken - Birds");
	}

	@Override
	public void eats() {
		System.out.println("Chicken - Eats");
	}
	
}
