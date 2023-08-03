package classex;

public class Dog {
	String name;
	int age;
	
	public Dog() {
//		this.name = "댕댕이";
//		this.age = 1;
		this("나비", 1);
	} //오버로딩된 생성자가 없으면 자동으로 생성
	
	public Dog(String name) {
		this.name = name;
	}
	
	public Dog(int age) {
		this.age = age;
	}
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args) {
//		Dog dog1 = new Dog();
//		dog1.name = "댕댕이";
//		dog1.age = 1;
//		Dog dog2 = new Dog("댕댕이");
//		Dog dog3 = new Dog(3);
		Dog dog4 = new Dog("댕댕이", 3);
//		Dog dog5 = new Dog("덕구", 2);
		System.out.println(dog4.name);
		System.out.println(dog4.age);
	}
}
