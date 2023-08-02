package arrayex;

import java.util.Scanner;

public class ArrayWord {

	public static void main(String[] args) {
		String[][] words = {{"apple", "사과"},
				{"banana", "바나나"},
				{"peach", "복숭아"}};
		
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<words.length; i++) {
			String exam = words[i][0];
			String ans = words[i][1];
			System.out.printf("Q%s. %s의 뜻은 무엇인가? \n", i+1, exam);
			String user = sc.next();
			if (ans.equals(user)) {
				System.out.println("정답!!");
			} else {
				System.out.println("오답!! 정답은 " + ans);
			}
		}
	}

}
