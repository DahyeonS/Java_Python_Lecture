package arrayex;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		String s1 = "red";
		String s2 = "green";
		String s3 = "blue";
		
		String[] sArr = new String[3];
		sArr[0] = s1;
		sArr[1] = s2;
		sArr[2] = s3;
		
		String[] sArr2 = {s1, s2, s3};
		
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		int i4 = 4;
		int i5 = 5;
		
		int[] iArr = new int[5];
		iArr[0] = i1;
		iArr[1] = i2;
		iArr[2] = i3;
		iArr[3] = i4;
		iArr[4] = i5;
		
		int[] iArr2 = {i1, i2, i3, i4, i5};
		
//		출력
		System.out.println(sArr[0]);
		System.out.println(iArr[2]);
		
		System.out.println(Arrays.toString(sArr));
		System.out.println(Arrays.toString(sArr2));
		System.out.println(Arrays.toString(iArr));
		System.out.println(Arrays.toString(iArr2));
		
//		.length
		int len = sArr.length; // (괄호가 없는 함수) 필드, 멤버변수, 속성 vs (괄호가 있는 함수) 메소드, 멤버함수, 기능
		System.out.println(len);
		System.out.println(sArr2.length);
	}

}
