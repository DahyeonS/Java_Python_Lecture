package methodex;

import java.util.Scanner;

public class MethodLocalVarEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		{
			int a = 10;
		}
		
//		int b = a;
		for (int i=0; i<n; i++) {
			int j = 0;
		}
//		nUse(sc);
	}
	public static int nUse(int n) {
		int y = n * n;
		return y;
	}
}
