package inheritancepkg;

public class Dog extends Animal {
	public Dog() {
//		super("바둑이", 3); // 부모 클래스의 변수는 super() 사용
	}
	
	public Dog(String name, int age) {
		super(name, age);
	}
}
