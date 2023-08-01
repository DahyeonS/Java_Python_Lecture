package arrayex;

import java.util.Arrays;

public class LottoOne {

	public static void main(String[] args) {
//		다음 0~9까지의 데이터를 배열에 담은 후 값을 섞(shuffle)어 랜덤한 순서가 되게 출력하시오.
		int arr[] = new int [45];
		for (int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		for (int i=0; i<10000; i++) { // 10000회 반복
			int r = (int)(Math.random() * 45);
			int temp = arr[0];
			arr[0] = arr[r];
			arr[r] = temp;
		}
		
		int[] lottoOne = new int[6];
		for (int i=0; i<lottoOne.length; i++) {
			lottoOne[i] = arr[i];
		}
		
		System.out.println(Arrays.toString(lottoOne));
	}
}
