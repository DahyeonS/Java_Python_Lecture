package iterationex;

import java.util.Scanner;

public class InfiniteRandomEx {

	public static void main(String[] args) {
//		1 ~ 100
//		for (int i=0; i<10; i++) {
//			int r = (int)(Math.random() * 100) + 1;
//			System.out.println(r);
//		}
		int com = (int)(Math.random() * 100) + 1;
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		while (true) {
			count++;
			System.out.print("user >> ");
			int user = sc.nextInt();
			if (com > user) System.out.println("com > user");
			else if (com < user) System.out.println("com < user");
			else {
				System.out.printf("Bingo: count %s!!!", count);
				break;
			}
		}
		sc.close(); // scanner를 함수를 불러올 때 사용하는 게 좋음
	}

}
