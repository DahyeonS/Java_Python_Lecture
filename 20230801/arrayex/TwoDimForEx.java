package arrayex;

public class TwoDimForEx {

	public static void main(String[] args) {
		/*
		int [][] iArr = new int[3][3];
		
		for (int i=0; i<iArr.length; i++) {
			for (int j=0; j<iArr[i].length; j++) {
				iArr[i][j] = j+i;
				System.out.printf("[%s][%s]", i, j);
			}
			System.out.println();
		}
		
		for (int i=0; i<iArr.length; i++) {
			for (int j=0; j<iArr[i].length; j++) {
				System.out.print(iArr[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		int [][] iArr = new int[3][];
		iArr[0] = new int[1];
		iArr[1] = new int[2];
		iArr[2] = new int[3];
		
		iArr[0][0] = 1;
		
		iArr[1][0] = 1;
		iArr[1][1] = 2;
		
		iArr[2][0] = 1;
		iArr[2][1] = 2;
		iArr[2][2] = 3;
		
		for (int i=0; i<iArr.length; ++i) {
			for (int j=0; j<iArr[i].length; j++) {
				System.out.print(iArr[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int[] arr: iArr) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}

}
