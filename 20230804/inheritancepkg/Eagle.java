package inheritancepkg;

public class Eagle extends Animal {
	public Eagle(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void move() {
		System.out.println("Move with wings!!");
	}
}
