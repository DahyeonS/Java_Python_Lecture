package classex;

public class InitBlockEx {
	static int staticInt;
	int instanceInt;
	
	static {
		staticAction();
		staticInt++;
		System.out.println("static init block");
	}
	
	{
		staticAction();
		instanceAction();
		instanceInt = staticInt;
		System.out.println("instance init block");
	}

	static void staticAction() {
		staticInt++;
	}
	void instanceAction() {
		staticInt++;
	}
	
	public static void main(String[] args) {
		InitBlockEx ib01 = new InitBlockEx();
		InitBlockEx ib02 = new InitBlockEx();
		InitBlockEx ib03 = new InitBlockEx();
	}
}
