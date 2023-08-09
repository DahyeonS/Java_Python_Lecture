package finalclass;

public class CatMain {

	public static void main(String[] args) {
		Cat cat = new Cat("나비");
		System.out.println(cat.age);
		cat.move();
		Dog dog = new Dog();
		dog.move();
	}
	
}
