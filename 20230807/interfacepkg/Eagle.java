package interfacepkg;

public class Eagle implements Animal {

	@Override
	public void sleep() {
		System.out.println("Eagle sleeps!!");
	}
	
	public void eat() {
		System.out.println("Eagle eats!!");
	}

}
