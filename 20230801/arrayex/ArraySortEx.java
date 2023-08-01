package arrayex;

import java.util.Arrays;

public class ArraySortEx {
	
	public static void main(String[] args) {
//		버블정렬: 다음 0~99까지의 랜덤한 데이터 10개를 배열에 담은 작은값부터 큰값으로 정렬 후 값을 출력하시오.
		int[] arr = new int[10];
		for (int i=0; i<arr.length; i++) {
			int r = (int)(Math.random() * 100);
			arr[i] = r;
		}
		System.out.println(Arrays.toString(arr));
		
		for (int i=0; i<arr.length-1; i++) {
			boolean changed = false;
			for (int j=0; j<arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					changed = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if (!changed) break; // 정렬이 완료되면 실행 중단
			System.out.println(Arrays.toString(arr));
		}
	}
}
