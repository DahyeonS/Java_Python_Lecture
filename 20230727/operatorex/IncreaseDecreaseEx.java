package operatorex;

public class IncreaseDecreaseEx {

	public static void main(String[] args) {
		int i = 0;
		i = i + 1;
		i++;
		System.out.println(i);
		
		i = i - 1;
		i--;
		System.out.println(i);
		
//		다른 변수에 대입할 때 위치(우선 순위)에 주의
		int n = 0;
		
		n = i++; // 넣고 더하기
		System.out.printf("i = %s, n = %s %n", i, n); // i = 1, n = 0
		
		n = ++i; // 더한 채로 넣기
		System.out.printf("i = %s, n = %s %n", i, n); // i = 2, n = 2
		
		n = i--; // 넣고 빼기
		System.out.printf("i = %s, n = %s %n", i, n); // i = 1, n = 2 
		
		n = --i; // 뺀 채로 넣기
		System.out.printf("i = %s, n = %s %n", i, n); // i = 0, n = 0 
	}

}
