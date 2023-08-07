package polymorphismpkg;

public class Eagle extends Animal implements Birds {

	@Override
	void info() {
		System.out.println("Eagle - Animal");
	}

	@Override
	public void birds() {
		System.out.println("Eagle - Birds");
	}
	
}
