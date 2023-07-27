package operatorex;

public class AssignEx {

	public static void main(String[] args) {
		int i = 0;
		i = i;
		i = i + 1;
		System.out.println(i); // 1
		
//		+=
		i = i + 1; // 2
		i += 1; // 3
		System.out.println(i); // 3
		
//		-=
		i = i - 1; // 2
		i -= 1; // 1
		System.out.println(i); // 1
		
//		*=
		i = i * 9; // 9
		i *= 9; // 81
		System.out.println(i); // 81
		
//		/=
		i = i / 3; // 27
		i /= 3; // 9
		System.out.println(i); // 9
		
//		%=
		i = i % 3; // (9 / 3 == 3)
		i %= 3; // (3 / 3 == 1)
		System.out.println(i); // 0
		
	}

}
