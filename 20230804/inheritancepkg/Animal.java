package inheritancepkg;

public class Animal extends Object {
	String name;
	int age;
	
	public Animal() {
		
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("Eat!!");
	}
	
	public void move() {
		System.out.println("Move!!");
	}
}
