package polymorphismpkg;

public class AnimalPolyEatsMain {

	public static void main(String[] args) {
		AnimalPrint ap = null;
		
		Eats eat1 = new Chicken();
		Eats eat2 = new Pig();
		ap = new AnimalPrint(eat1);
		ap = new AnimalPrint(eat2);
	}

}
