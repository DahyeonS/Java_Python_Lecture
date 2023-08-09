package finalclass;

public class Dog extends Animal {
	public Dog() {
		super("바둑이", 1);
	}
	
	@Override
	public void move() {
		System.out.println("Dog Move!!");
	}
}
