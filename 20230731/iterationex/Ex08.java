package iterationex;

public class Ex08 {
	/*
	  	*
	   ***
	  *****
	 *******
	*********
	*/
	public static void main(String[] args) {
		int star = 11;
		int space = star / 2;
		int n = space + 1; //4
		for (int i=1; i<star; i+=2) {
			for (int j=0; j<space; j++) {
				System.out.print(" ");
			}
			for (int k=0; k<i; k++) {
				System.out.print("*");
			}
			space--;
			System.out.println();
		}
	}

}
