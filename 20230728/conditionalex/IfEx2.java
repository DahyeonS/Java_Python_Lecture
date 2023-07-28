package conditionalex;

public class IfEx2 {

	public static void main(String[] args) {
//		60점 이상이고 짝수이면 Even Num Pass
//		60점 이상이고 홀수이면 Odd Num Pass
//		60점 미만이고 짝수이면 Even Num Fail
//		60점 이상이고 홀수이면 Odd Num Fail
		int score = 60;
		String evenPass = "Even Num Pass";
		String oddPass = "Odd Num Pass";
		String evenFail = "Even Num Fail";
		String oddFail = "Odd Num Fail";
		boolean cond = score >= 60;
		boolean cond2 = score % 2 == 0;
		
		if (cond && cond2) {
			System.out.println(evenPass);
		} else if (cond && !cond2) {
			System.out.println(oddPass);
		} else if (!cond && cond2) {
			System.out.println(evenFail);
		} else if (!cond && !cond2) {
			System.out.println(oddFail);
		}
		
//		if 중첩
		if (cond) {
			if (cond2) {
				System.out.println(evenPass);
			} else {
				System.out.println(oddPass);
			}
		} else {
			if (cond2) {
				System.out.println(evenFail);
			} else {
				System.out.println(oddFail);
			}
		}
		
		if (score >= 60) {
			if (score % 2 == 0) {
				System.out.println(evenPass);
			} else {
				System.out.println(oddPass);
			}
		} else {
			if (score % 2 == 0) {
				System.out.println(evenFail);
			} else {
				System.out.println(oddFail);
			}
		}
	}

}
