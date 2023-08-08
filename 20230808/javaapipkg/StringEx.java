package javaapipkg;

public class StringEx {

	public static void main(String[] args) {
		String text = "0123456789";
		char c = text.charAt(4);
		
		for (int i=0; i<text.length(); i++) {
			System.out.print(text.charAt(i) + " ");
		}
	}

}
