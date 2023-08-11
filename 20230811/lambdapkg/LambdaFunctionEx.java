package lambdapkg;

public class LambdaFunctionEx {

	public static void main(String[] args) {
		InterfaceEx ie1 = (int x, int y) -> x + y;
	}

}

interface InterfaceEx {
	public int calc(int x, int y);
}