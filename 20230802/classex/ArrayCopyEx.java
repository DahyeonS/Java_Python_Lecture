package arrayex;

import java.util.Arrays;

public class ArrayCopyEx {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		
		int[] arr2 = new int[10];
		for (int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		for (int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		System.out.println(arr1);
		System.out.println(arr2);
		/*
		System.out.println(Arrays.toString(arr2));
		arr1 = arr2;
		System.out.println(Arrays.toString(arr1));
		
		System.out.println(arr1);
		
		arr2[5] = 100;
		System.out.println(arr2[5]);
		System.out.println(arr1[5]);
		
		arr1[6] = 1000;
		System.out.println(arr1[6]);
		System.out.println(arr2[6]);
		*/
		int[] arr3 = new int[10];
		System.arraycopy(arr1, 0, arr3, 3, arr1.length);
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = null;
		arr4 = Arrays.copyOf(arr1, arr1.length+5);
		System.out.println(Arrays.toString(arr4));
		
	}

}
