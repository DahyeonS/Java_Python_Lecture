package arrayex;

import java.util.Arrays;

public class ArrayTest03 {

	public static void main(String[] args) {
//		다음 0~9까지의 데이터를 배열에 담은 후 값을 섞(shuffle)어 랜덤한 순서가 되게 출력하시오.
		int arr[] = new int [10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		
		for (int i=0; i<10000; i++) { // 10000회 반복
			int r = (int)(Math.random() * 10);
			int temp = arr[0];
			arr[0] = arr[r];
			arr[r] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

}
