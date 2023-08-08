package javaapipkg;

public class StringParseEx {

	public static void main(String[] args) {
		String[] str = {"1", "2", "3", "4", "5"};
		int sum = 0;
		
		for (int i=0; i<str.length; i++) {
			sum += Integer.parseInt(str[i]);
		}
		
		sum = 0;
		for (String s : str) {
			sum += Integer.parseInt(s);
		}
		
		double sum2 = 0;
		for (String s : str) {
			sum2 += Double.parseDouble(s);
		}
		System.out.println(sum);
		System.out.println(sum2);
	}

}
