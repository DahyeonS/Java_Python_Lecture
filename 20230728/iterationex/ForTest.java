package iterationex;

public class ForTest {

	public static void main(String[] args) {
//		11111
//		22222
//		33333
//		44444
//		55555
		for (int i=1; i<=5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println("====================================");
		
//		2 ~ 9단까지의 구구단 출력 해보기
		for (int i=2; i<10; i++) {
			System.out.printf("%s단 %n", i);
			System.out.println("***********");
			for (int j=1; j<10; j++) {
				System.out.printf("%s * %s = %s %n", i, j, i * j);
			}
			System.out.println("***********");
		}
		
		System.out.println("====================================");
		
//		1부터 100까지의 수 중 짝수와 홀수의 합을 각각 구하시오
		int even = 0, odd = 0;
		for (int i=1; i<=100; i++) {
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
		}
		System.out.printf("짝수의 합: %s, 홀수의 합: %s %n", even, odd);
		
//		1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		int sum = 0;
		for (int i=1; i<=20; i++) {
			if (!(i % 2 == 0 | i % 3 == 0)) {
				sum += i;
			}
		}
		System.out.println("총합: " +sum);
		
//		1+1+2+1+2+3+1+2+3+4+...+1+2+3+...+10 의 결과값을 구하시오.
		sum = 0;
		int sum2 = 0;
		for (int i=1; i<=10; i++) {
			sum += i;
			sum2 += sum;
		}
		System.out.println("결과: " + sum2);
		
//		PizzBuzz 찍기
		for (int i=1; i<=100; i++) {
			if (i % 3 == 0 & i % 5 == 0) {
				System.out.println(i + " FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println(i + " Fizz");
			} else if (i % 5 == 0) {
				System.out.println(i + " Buzz");
			} else {
				System.out.println(i);
			}
		}
		
		System.out.println("====================================");
		
//		1  2  3  4  5 
//		6  7  8  9  10
//		11 12 13 14 15
//		16 17 18 19 20
//		21 22 23 24 25
		for (int i=1; i<=25; i++) {
//			System.out.printf("%2d ", i);
			System.out.print(i + " ");
			if (i < 10) System.out.print(" ");
			if (i % 5 == 0) {
				System.out.println();
				}
			}
		
		System.out.println("====================================");
		
//		1
//		1 2
//		1 2 3
//		1 2 3 4
//		1 2 3 4 5
		for (int i=1; i<=5; i++) {
			for (int j=i-1; j>=0; j--) {
				System.out.printf("%2d", i-j);
			}
			System.out.println();
		}
		
		System.out.println("====================================");
		
//		*
//		**
//		***
//		****
//		*****
		for (int i=1; i<=5; i++) {
			for (int j=i-1; j>=0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("====================================");
		
//		    *
//		   ***
//		  *****
//		 *******
//		*********
		for (int i=0; i<5; i++) {
			for (int j=0; j<=3-i; j++) {
				System.out.print(" ");
			}
			for (int j=0; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("====================================");
		
//		(1,1) (1,2) (1,3) (1,4) (1,5) (1,6)
//		(2,1) (2,2) (2,3) (2,4) (2,5) (2,6)
//		(3,1) (3,2) (3,3) (3,4) (3,5) (3,6)
//		(4,1) (4,2) (4,3) (4,4) (4,5) (4,6)
//		(5,1) (5,2) (5,3) (5,4) (5,5) (5,6)
//		(6,1) (6,2) (6,3) (6,4) (6,5) (6,6)
		for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				System.out.printf("(%d,%d) ", i, j);
			}
			System.out.println();
		}
		
		System.out.println("====================================");
		
//		두 개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 구하시오.
		for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				if (i + j == 6) {
					System.out.printf("%d, %d %n", i, j);
				}
			}
		}
		
		System.out.println("====================================");
		
//		2x+4y=10 방정식의 해 x y를 구하시오. 범위 0<=x<=10, 0<=y<=10
		for (int x=0; x<=10; x++) {
			for (int y=0; y<=10; y++) {
				if (2*x + 4*y == 10) {
					System.out.printf("x는 %d, y는 %d %n", x, y);
				}
			}
		}
	}

}
