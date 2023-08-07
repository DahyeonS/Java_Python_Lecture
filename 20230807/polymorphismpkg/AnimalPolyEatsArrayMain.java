package polymorphismpkg;

public class AnimalPolyEatsArrayMain {

	public static void main(String[] args) {
		Eats[] eatArr = new Eats[2];
		eatArr[0] = new Chicken();
		eatArr[1] = new Pig();
		
		AnimalPrint ap = new AnimalPrint(eatArr);
	}

}
