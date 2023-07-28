package conditionalex;

public class SwitchEx {

	public static void main(String[] args) {
		int score = 80;
		String grade = "";
		
		if (score >= 95) grade = "A+"; // 실행문이 1개일 때는 { }를 생략 가능
		else if (score >= 90) grade = "A";
		else if (score >= 80) grade = "B";
		else if (score >= 70) grade = "C";
		else if (score >= 60) grade = "D";
		else grade = "F";
		System.out.println(grade);
		
		switch (score) {
		case 95 :
			grade = "A+";
			break;
		case 90 :
			grade = "A";
			break;
		case 80 :
			grade = "B";
			break;
		case 70 :
			grade = "C";
			break;
		case 60 :
			grade = "D";
			break;
		default :
			grade = "F";
		}
		System.out.println(grade);
	}

}
