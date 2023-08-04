package inheritancepkg;

public final class FinalAnimal extends Animal {
	final int wings = 2;
	final int legs = 4;
	final int eyes = 8;
	
	public FinalAnimal(String name, int age) {
		super(name, age);
	}
	
	/*
//	fianl 선언 시 불가능
	public FinalAnimal(int wings, int legs, int eyes) {
		this.wings = wings;
		this.legs = legs;
		this.eyes = eyes;
	}
	*/

	@Override
	public void move() {
		System.out.println("Move with wings and legs");
	}

}
