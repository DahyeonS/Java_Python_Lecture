package finalclass;

public class Cat extends Animal {
//	member var

	public Cat(String name) {
		super(name, 3);
	}
	
	public Cat(String name, int age) {
		super(name, age);
	}
	
//	method
	@Override
		public void move() {
		System.out.println("Cat Move!!");
		}
}
