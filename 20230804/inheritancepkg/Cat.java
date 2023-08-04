package inheritancepkg;

public class Cat extends Animal {
	public Cat(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void move() {
		System.out.println("Move with leg!!");
	}
}
