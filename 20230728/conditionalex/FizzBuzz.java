package conditionalex;

import java.util.Scanner;

public class FizzBuzz {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 => ");
		int i = sc.nextInt();
		
//		1개의 정수를 입력 받아서 3의 배수이면 Fizz를 출력 하시오.
		if (i % 3 == 0) System.out.println("Fizz");
		
//		1개의 정수를 입력 받아서 5의 배수이면 Buzz를 출력 하시오.
		if (i % 5 == 0) System.out.println("Buzz");
		
//		1개의 정수를 입력 받아서 3의 배수이고 5의 배수이면 FizzBuzz를 출력 하시오.
		if (i % 3 == 0 & i % 5 == 0) System.out.println("FizzBuzz");
		
//		1개의 정수를 입력 받아서 3의 배수이고 5의 배수이면 FizzBuzz, 3의 배수면 Fizz, 5의 배수면 Buzz를 출력 하시오.
		if (i % 3 == 0 & i % 5 == 0) System.out.println("FizzBuzz");
		else if (i % 3 == 0) System.out.println("Fizz");
		else if (i % 5 == 0) System.out.println("Buzz");
	}

}
