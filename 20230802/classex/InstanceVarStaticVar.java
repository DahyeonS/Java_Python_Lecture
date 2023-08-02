package classex;

import hello.Bus;

public class InstanceVarStaticVar {
	
	static int staticInt;
	static String staticString;
	
	int instantInt;
	String instantString;

	public static void main(String[] args) {
		int localInt = 0;
		String localString = "";
		
		InstanceVarStaticVar ivsv = new InstanceVarStaticVar();
		
		System.out.println(localInt);
		System.out.println(staticInt);
		System.out.println(ivsv.instantInt);
		System.out.println(Car.color);
		System.out.println(Bus.color);
	}

}
