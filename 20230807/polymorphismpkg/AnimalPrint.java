package polymorphismpkg;

import java.util.ArrayList;

public class AnimalPrint {
	public AnimalPrint(Chicken chicken) {
		chicken.info();
		chicken.birds();
		chicken.eats();
	}
	
	public AnimalPrint(Eagle eagle) {
		eagle.info();
		eagle.birds();
	}
	
	public AnimalPrint(Tiger tiger) {
		tiger.info();
	}
	
	public AnimalPrint(Pig pig) {
		pig.info();
		pig.eats();
	}
	
//	상속 - 다형성
	public AnimalPrint(Animal animal) {
		animal.info();
	}
	
//	상속 - 다형성 Array
	public AnimalPrint(Animal[] animalaArr) {
		for (Animal animal : animalaArr) {
			animal.info();
		}
	}
	
//	인터페이스 - 다형성
	public AnimalPrint(Birds birds) {
		birds.birds();
	}
	
	public AnimalPrint(Eats eats) {
		eats.eats();
	}
	
//	인터페이스 - 다형성 Array
	public AnimalPrint(Birds[] birdArr) {
		for (Birds birds : birdArr)
			birds.birds();
	}
	
	public AnimalPrint(Eats[] eatArr) {
		for (Eats eats : eatArr)
			eats.eats();
	}
	
//	상속 - 다형성 ArrayList
	public AnimalPrint(ArrayList animalList) {
		for (Object oAnimal : animalList) {
			Animal animal = (Animal)oAnimal;
			animal.info();
		}
	}
}
