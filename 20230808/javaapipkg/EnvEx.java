package javaapipkg;

public class EnvEx {

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		
		for (String key : System.getenv().keySet()) {
			System.out.println(key + ": " + System.getenv(key));
		}
	}

}
