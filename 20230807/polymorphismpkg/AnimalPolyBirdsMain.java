package polymorphismpkg;

public class AnimalPolyBirdsMain {

	public static void main(String[] args) {
		AnimalPrint ap = null;
		
		Birds bird1 = new Chicken();
		Birds bird2 = new Eagle();
		ap = new AnimalPrint(bird1);
		ap = new AnimalPrint(bird2);
	}

}
