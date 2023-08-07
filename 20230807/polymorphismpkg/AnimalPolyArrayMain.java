package polymorphismpkg;

public class AnimalPolyArrayMain {

	public static void main(String[] args) {
		Animal chicken = new Chicken();
		Animal eagle = new Eagle();
		Animal tiger = new Tiger();
		Animal pig = new Pig();
		
		Animal[] animalArr = new Animal[4];
		animalArr[0] = chicken;
		animalArr[1] = eagle;
		animalArr[2] = tiger;
		animalArr[3] = pig;
		
		AnimalPrint ap = null;
		ap = new AnimalPrint(animalArr);
	}

}
