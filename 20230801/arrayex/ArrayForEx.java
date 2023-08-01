package arrayex;

public class ArrayForEx {

	public static void main(String[] args) {
//		1 ~ 100까지 int 배열에 저장하시오.
		int [] iArr = new int[100];
		for (int i=0; i<100; i++) {
			iArr[i] = i + 1;
		}
		
//		System.out.println(Arrays.toString(iArr));
		
		int len = iArr.length;
		
		for (int i=0; i<len; i++) {
			System.out.print(iArr[i] + " ");
		}
		
		System.out.println();
		
		for (int i : iArr) { // iArr의 길이만큼 출력
			System.out.print(i + " ");
		}
	}

}
