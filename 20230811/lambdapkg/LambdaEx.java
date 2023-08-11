package lambdapkg;

public class LambdaEx {
	
	public static void main(String[] args) {
		LambdaInterface li = (String name) -> {
			String str = "msg";
			System.out.println(str);
		};
		li.print("홍길동");
	}
	
}

@FunctionalInterface
interface LambdaInterface {
	void print(String name);
//	void print2();
}