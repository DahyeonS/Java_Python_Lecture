package inputex;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		변수 2개를 입력해서 사칙연산
		System.out.print("숫자 2개를 공백으로 구분해서 입력하세요.");
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		System.out.println("덧셈: " + (x1 + x2));
		System.out.println("뺄셈: " + (x1 - x2));
		System.out.println("곱셈: " + (x1 * x2));
		System.out.println("나눗셈: " + ((double)x1 / x2));
		
		System.out.print("숫자 3개를 공백으로 구분해서 입력하세요.");
		int x3 = sc.nextInt();
		int x4 = sc.nextInt();
		int x5 = sc.nextInt();
		System.out.println("덧셈: " + (x3 + x4 + x5));
		System.out.println("뺄셈: " + (x3 - x4 - x5));
		System.out.println("곱셈: " + (x3 * x4 * x5));
		System.out.println("나눗셈: " + ((double)x3 / x4 / x5));
	}

}
