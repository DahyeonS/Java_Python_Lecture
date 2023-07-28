package iterationex;

public class CumulateEx {

	public static void main(String[] args) {
//		1 ~ 5 합 누적
		int sum = 0;
		
		for (int i=1; i<6; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}
