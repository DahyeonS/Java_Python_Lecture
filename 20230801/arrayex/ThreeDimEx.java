package arrayex;

public class ThreeDimEx {

	public static void main(String[] args) {
		int[][][] iArr = new int[3][3][3];
		int value = 0;
		for (int i=0; i<iArr.length; i++) {
			for (int j=0; j<iArr[i].length; j++) {
				for (int k=0; k<iArr[i][j].length; k++) {
					iArr[i][j][k] = value++;
				}
			}
		}
		
		for (int[][] arr2 : iArr) {
			for (int[] arr : arr2) {
				for (int i : arr) {
					System.out.printf(i + " ");
				}
				System.out.println();
			}
		}
	}

}
