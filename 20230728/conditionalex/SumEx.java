package conditionalex;

import java.util.Scanner;

public class SumEx {

	public static void main(String[] args) {
//		2개의 정수를 입력 받아서 각각의 수가 짝수면 합을 구하고 한 개라도 홀수면 곱을 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 2개 입력 => ");
		int i1 = sc.nextInt();
		int i2 = sc.nextInt();
		
		if (i1 % 2 == 0 & i2 % 2 == 0) {
			int result = i1 + i2;
			System.out.println(result);
		} else {
			int result = i1 * i2;
			System.out.println(result);
		}
		
		if (i1 % 2 == 0 & i2 % 2 == 0) System.out.println(i1 + i2);
		else System.out.println(i1 * i2);
	}

}
