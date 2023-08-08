package exceptionpkg;

public class Exception02 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception!!");
		} finally {
			System.out.println("무조건 Finally");
		}
		System.out.println(6);
	}

}
