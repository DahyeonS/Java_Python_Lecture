package polymorphismpkg;

public class AnimalPolyBirdsArrayMain {

	public static void main(String[] args) {
		Birds[] birdArr = new Birds[2];
		birdArr[0] = new Chicken();
		birdArr[1] = new Eagle();
		
		AnimalPrint ap = null;
		ap = new AnimalPrint(birdArr);
	}

}
