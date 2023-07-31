package iterationex;

public class Ex09 {
	/*
	(1,1) (1,2) (1,3) (1,4) (1,5), (1,6)
	(2,1) (2,2) (2,3) (2,4) (2,5), (2,6)
	(3,1) (3,2) (3,3) (3,4) (3,5), (3,6)
	(4,1) (4,2) (4,3) (4,4) (4,5), (4,6)
	(5,1) (5,2) (5,3) (5,4) (5,5), (5,6)
	(6,1) (6,2) (6,3) (6,4) (6,5), (6,6)
	 */
	public static void main(String[] args) {
		for (int i=1; i<7; i++) {
			for (int j=1; j<7; j++) {
				System.out.printf("(%s,%s) ", i, j);
			}
			System.out.println();
		}
	}

}
