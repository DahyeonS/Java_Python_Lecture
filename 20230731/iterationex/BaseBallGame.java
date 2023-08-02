package iterationex;

import java.util.Scanner;

public class BaseBallGame {

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
		int com1 = 0;
		int com2 = 0;
		int com3 = 0;
				
		while (true) {
			com1 = (int)(Math.random()* 9) + 1;
			com2 = (int)(Math.random()* 9) + 1;
			com3 = (int)(Math.random()* 9) + 1;
//			if (com1 != com2 & com2 != com3 & com1 != com3) break;
			if (!(com1 == com2 || com1 == com3 || com2 == com3)) break;
		}
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		while (true) {
			System.out.println("중복되지 않는 3자리 수(1 ~ 9)");
			System.out.print("공백으로 3자리 ex) 1 2 3 >> ");
			int user1 = sc.nextInt();
			int user2 = sc.nextInt();
			int user3 = sc.nextInt();
			int strike = 0, ball = 0, out = 0;
			
			if (user1 == user2 || user1 == user3 || user2 == user3) {
				System.out.println("다시 입력하세요.");
			} else {
				count++;
				if (com1 == user1) strike++;
				else if (com1 == user2) ball++;
				else if (com1 == user3) ball++;
				
				if (com2 == user2) strike++;
				else if (com2 == user1) ball++;
				else if (com2 == user3) ball++;
				
				if (com3 == user3) strike++;
				else if (com3 == user1) ball++;
				else if (com3 == user2) ball++;
				
				out = 3 - (strike + ball);
				
				if (strike != 3) {
					System.out.printf("%s Strike %s Ball %s Out%n", strike, ball, out);
				}
				else {
					System.out.printf("%s Strike %s Ball %s Out%n", strike, ball, out);
					System.out.printf("com : %s%s%s%n", com1, com2, com3);
					System.out.printf("%s번 만에 성공!!", count); break;
				}
			}
		}
		sc.close();
	}

}
