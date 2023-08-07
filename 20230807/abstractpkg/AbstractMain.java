package abstractpkg;

public class AbstractMain {

	public static void main(String[] args) {
//		AbstractClass ab = new AbstractClass(); // 불가능
		AbstractChildClass acc = new AbstractChildClass();
		acc.abstractMethod();
		AbstractClass ac = new AbstractChildClass(){}; // 다형성
		ac.abstractMethod();
	}

}
