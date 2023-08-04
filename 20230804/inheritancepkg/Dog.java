package inheritancepkg;

public class Dog extends Animal {
	public Dog() {
//		super("바둑이", 3); // 상속 관계에서 값이 정해졌을 때 호출 필요
	}
	
	public Dog(String name, int age) {
		super(name, age);
	}
}
