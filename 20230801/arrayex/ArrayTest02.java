package arrayex;

public class ArrayTest02 {

	public static void main(String[] args) {
		int [] score = {79, 88, 91, 33, 100, 55, 95};
//		score의 최대, 최소값을 구하시오.
		int max = 0, min = 0;
		max = score[0];
		min = score[0];
		
		for (int i=0; i<score.length; i++) {
			if (score[i] > max) {
				max = score[i];
			} else if (score[i] < min) {
				min = score[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
	}

}
