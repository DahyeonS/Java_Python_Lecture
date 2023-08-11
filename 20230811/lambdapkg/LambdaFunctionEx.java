package lambdapkg;

public class LambdaFunctionEx {

	public static void main(String[] args) {
		InterfaceEx ie1 = (int x, int y) -> x + y;
		InterfaceEx ie2 = (int x, int y) -> x - y;
		InterfaceEx ie3 = (int x, int y) -> x * y;
		InterfaceEx ie4 = (int x, int y) -> x / y;
		System.out.println(ie1.calc(5, 4));
		System.out.println(ie2.calc(5, 4));
		System.out.println(ie3.calc(5, 4));
		System.out.println(ie4.calc(5, 4));
	}

}

interface InterfaceEx {
	public int calc(int x, int y);
}