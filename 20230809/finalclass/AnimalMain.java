package finalclass;

import java.util.ArrayList;
import java.util.List;

public class AnimalMain {

	public static void main(String[] args) {
		Animal cat = new Cat("나비");
		Animal dog = new Dog();
		Animal eagle = new Eagle("독수리", 2);
		Animal chicken = new Chicken("꼬꼬", 2);
		
		Animal[] animalArr = new Animal[4];
		animalArr[0] = cat;
		animalArr[1] = dog;
		animalArr[2] = eagle;
		animalArr[3] = chicken;
		
		List animalList = new ArrayList();
		animalList.add(cat);
		animalList.add(dog);
		animalList.add(eagle);
		animalList.add(chicken);
		
		
		Egg eagle2 = new Eagle("독수리", 2);
		Egg chicken2 = new Chicken("꼬꼬", 2);
		
		Egg[] eggArr = new Egg[2];
		eggArr[0] = eagle2;
		eggArr[1] = chicken2;
		
		List eggList = new ArrayList();
		eggList.add(eagle2);
		eggList.add(chicken2);
		
		AnimalUtil au = new AnimalUtil();
		au.printName(chicken);
		System.out.println();
		au.printName(cat);
		System.out.println();
		au.printName(animalArr);
		System.out.println();
		au.printName(animalList);
		System.out.println();
		au.printAge(chicken2);
		System.out.println();
		au.printAge(eggArr);
		System.out.println();
		au.printAge(eggList);
	}

}
