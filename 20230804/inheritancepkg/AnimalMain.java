package inheritancepkg;


public class AnimalMain {

	public static void main(String[] args) {
//		Animal a = new Animal();
//		a.eat();
//		
//		Dog dog = new Dog();
//		dog.name = "바둑이";
//		dog.age = 3;
//		dog.eat();
//		dog.move();
		
		Dog dog = new Dog("바둑이", 1);
		Cat cat = new Cat("나비", 2);
		Eagle eagle = new Eagle("독수리", 3);
		dog.move();
		cat.move();
		eagle.move();
	}

}
