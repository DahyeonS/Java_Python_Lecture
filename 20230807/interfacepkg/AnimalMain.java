package interfacepkg;

public class AnimalMain {

	public static void main(String[] args) {
		Animal animal = new Eagle();
		
		animal.sleep();
		
		Eagle eagle = (Eagle)animal;
		eagle.sleep();
		eagle.eat();
	}

}
