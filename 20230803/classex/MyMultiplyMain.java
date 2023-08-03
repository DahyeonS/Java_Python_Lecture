package classex;

public class MyMultiplyMain {

	public static void main(String[] args) {
		MyMultiply mm = new MyMultiply();
		
		int rs = mm.multiply(100, 50);
		double rdD = mm.multiply(20.0, 5.0);
		System.out.println(rs);
		System.out.println(rdD);
	}

}
