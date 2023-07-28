package conditionalex;

public class IfEx {

	public static void main(String[] args) {
		int score = 60;
		String pass = "pass";
		String fail = "fail";
		boolean b = score >= 60;
		
		if (b) {
			System.out.println(pass);
		} else {
			System.out.println(fail);
		}
		
		score = 70;
		if (score > 60) {
			System.out.println(pass);
		} else if (score == 60) {
			System.out.println(pass);
		} else if (score < 60) {
			System.out.println(fail);
		}
		
		score = 50;
		if (score > 60) {
			System.out.println(pass);
		} else if (score == 60) {
			System.out.println(pass);
		} else if (score < 60) {
			System.out.println(fail);
		}
		
		if (score > 60) {
			System.out.println(pass);
		}
		if (score == 60) {
			System.out.println(pass);
		}
		if (score < 60) {
			System.out.println(fail);
		}
	}

}
