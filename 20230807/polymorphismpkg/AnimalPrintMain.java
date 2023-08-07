package polymorphismpkg;

public class AnimalPrintMain {

	public static void main(String[] args) {
		Chicken chicken = new Chicken();
		Eagle eagle = new Eagle();
		Tiger tiger = new Tiger();
		Pig pig = new Pig();
		
		AnimalPrint ap = null;
		ap = new AnimalPrint(chicken);
		ap = new AnimalPrint(eagle);
		ap = new AnimalPrint(tiger);
		ap = new AnimalPrint(pig);
	}

}
