package arrayex;

public class ArrayTest01 {

	public static void main(String[] args) {
		int[] score = {100, 88, 100, 100, 90};
//		총합과 평균을 출력하시오.
		int sum = 0;
		int avg = 0;
		
		
		for (int i=0; i<score.length; i++) {
			sum += score[i];
//			System.out.println(score[i]);
		}
		avg = sum / score.length;
		System.out.println(sum);
		System.out.println(avg);
		
		sum = 0;
		
		for (int i : score) {
			sum += i;
		}
		System.out.println(sum);
	}

}
