package iterationex;

public class ForEx2 {

	public static void main(String[] args) {
		String start = "*****";
//		*****
//		*****
//		*****
//		*****
//		*****
		
		for (int i=0; i<5; i++) {
			System.out.println(start);
		}
		
		System.out.println("===========================");
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
