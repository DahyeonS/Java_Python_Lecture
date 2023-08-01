package arrayex;

public class TwoDimArray {

	public static void main(String[] args) {
		int [] iArr = new int [3];
		
		int [][] iArr2 = new int [3][];
		iArr2[0] = iArr;
		iArr2[1] = iArr;
		iArr2[2] = iArr;
		
		iArr2[0] = new int[1];
		iArr2[1] = new int[2];
		iArr2[2] = new int[3];
		
		iArr2[0][0] = 1;
		
		iArr2[1][0] = 1;
		iArr2[1][1] = 2;
		
		iArr2[2][0] = 1;
		iArr2[2][1] = 2;
		iArr2[2][2] = 3;
		
		System.out.println(iArr2);
		System.out.println(iArr2[0]);
		System.out.println(iArr2[1]);
		System.out.println(iArr2[2]);
		System.out.println(iArr2.length); // 3
		System.out.println(iArr2[0].length); // 1
		System.out.println(iArr2[1].length); // 2
		System.out.println(iArr2[2].length); // 3
	}

}
