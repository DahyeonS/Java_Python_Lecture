package polymorphismpkg;

import inheritancepkg.Animal;
import inheritancepkg.Cat;
import inheritancepkg.Dog;
import inheritancepkg.Eagle;
import inheritancepkg.FinalAnimal;

public class AnimalPolyMain {

	public static void main(String[] args) {
		Animal animal1 = new Dog("dog1", 1);
		Animal animal2 = new Cat("cat1", 2);
		Animal animal3 = new Eagle("eagle3", 3);
//		Animal[] animalArr = new Animal[3];
//		animalArr[0] = animal1;
//		animalArr[2] = animal2;
//		animalArr[3] = animal3;
		
		animal1.move();
		animal2.move();
		animal3.move();
		
		Dog dog = (Dog) animal1;
		Cat cat = (Cat) animal2;
		Eagle eagle = (Eagle) animal3;
		
		dog.move();
		cat.move();
		eagle.move();
		
		FinalAnimal finalAnimal = new FinalAnimal("fianl1", 4);
	}

}
