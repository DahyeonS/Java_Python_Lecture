package datatypeex;

public class VarCast {

	public static void main(String[] args) {
		
		int i = 1000;
		
//		자동 형변환
		long l = i; // long > int
		
		float f = 3.14F;
		double d = f;
		
//		자동 형변환
		f = i;
		f = l;
		
//		l = 3000000000; // Error 자동 형변환 실패
		l = 3000000000L;
		
		/* Error 자동 형변환 실패
		i = l;
		i = f;
		*/
		
		i = (int)l;
		f = (float)d;
		
		System.out.println(l);
		System.out.println(i);
		
	}

}
