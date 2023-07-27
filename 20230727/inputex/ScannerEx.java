package inputex;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 넣어주세요.");
		String x1 = sc.nextLine();
		System.out.println("두번째 숫자를 넣어주세요.");
		String x2 = sc.nextLine();
		System.out.println(x1);
		System.out.println(x2);
		
		System.out.println("숫자 2개를 공백으로 구분해서 넣어주세요.");
		String x3 = sc.next();
		String x4 = sc.next();
		System.out.println(x3);
		System.out.println(x4);
		
		int ix3 = Integer.parseInt(x3);
		int ix4 = Integer.parseInt(x4);
		int result = ix3 + ix4;
		System.out.println(result);
		
		System.out.println("숫자 2개를 공백으로 구분해서 넣어주세요.");
		int x5 = sc.nextInt();
		int x6 = sc.nextInt();
		result = x5 + x6;
		System.out.println(result);
	}

}
