package polymorphismpkg;

public class AnimalPolyMain {

	public static void main(String[] args) {
		Animal chicken = new Chicken();
		Animal eagle = new Eagle();
		Animal tiger = new Tiger();
		Animal pig = new Pig();
		
		AnimalPrint ap = null;
		ap = new AnimalPrint(chicken);
		ap = new AnimalPrint(eagle);
		ap = new AnimalPrint(tiger);
		ap = new AnimalPrint(pig);
		
		Birds bird1 = new Chicken();
		Birds bird2 = new Eagle();
		ap = new AnimalPrint(bird1);
		ap = new AnimalPrint(bird2);
	}

}
