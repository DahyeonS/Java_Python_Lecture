package javaapipkg;

public class ClassEx {

	public static void main(String[] args) {
		EnvEx env = new EnvEx();
		Class c1 = env.getClass();
		System.out.println(c1.getName());
		System.out.println(c1.getPackageName());
	}

}
