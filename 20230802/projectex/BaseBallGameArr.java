package projectex;

import java.util.Scanner;

public class BaseBallGameArr {
	
	public static boolean ischeck(int[] arr) {
		boolean check = false;
		int len = arr.length;
		for(int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {
				if (i != j) {
					if (arr[i] == arr[j]) {
						check = true;
						return check;
					}
				}
			}
		}
		return check;
	}

	public static void main(String[] args) {
		/*
		** 규칙
		규칙 : 1~9 사이의 중복되지 않은 랜덤한 3자리 숫자 맞추기
		com :  1 3 5
		user : 2 3 4 => 1Strike 2Out(3이 숫자, 자리수 모두 맞음)
		user : 3 7 9 => 1Ball 2Out (3이 숫자만 맞음)
		user : 6 7 8 => 3Out (맞음 없음)
		user : 1 3 5 => 3Strike (모두 맞음, 게임 종료 )
		*/
		int[] com = new int[3];
		int[] user = new int[3];
				
		while (true) {
			for (int i=0; i<com.length; i++) {
				com[i] = (int)(Math.random()* 9) + 1;
			}
			boolean check = ischeck(com); // false
			if (!check) break;
		}
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.println("중복되지 않는 3자리 수(1 ~ 9)");
			System.out.print("공백으로 3자리 ex) 1 2 3 >> ");
			user[0] = sc.nextInt();
			user[1] = sc.nextInt();
			user[2]= sc.nextInt();
			int strike = 0, ball = 0, out = 0;
			
			boolean check = ischeck(user);
			if (check) {
				System.out.println("중복된 값이 있습니다. 다시 입력하세요.");
			} else {
				count++;
				int len = com.length;
				for (int i=0; i<len; i++) {
					for (int j=0; j<len; j++) {
						if (user[i] == com[j]) {
							if (i == j) strike++;
							else ball++;
						}
					}
				}
				
				out = 3 - (strike + ball);
				
				if (strike != 3) {
					System.out.printf("%s Strike %s Ball %s Out%n", strike, ball, out);
				}
				else {
					System.out.printf("%s Strike %s Ball %s Out%n", strike, ball, out);
					System.out.printf("com : %s%s%s%n", com[0], com[1], com[2]);
					System.out.printf("%s번 만에 성공!!", count); break;
				}
			}
		}
		sc.close();
	}

}
