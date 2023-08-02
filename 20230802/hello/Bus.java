package hello;

public class Bus {
	public static String color;
	String company;
	int door;
	
	void go() {
		System.out.printf("%s %s가 전진합니다.\n", color, company);
	}
	
	void back() {
		System.out.printf("%s %s가 후진합니다.\n", color, company);
	}
}
