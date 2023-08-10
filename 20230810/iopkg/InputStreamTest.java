package iopkg;

import java.io.IOException;

public class InputStreamTest {

	public static void main(String[] args) {
		int ch = -1;
		System.out.print("문자 입력 > ");
		do {
			try {
				ch = System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (ch == 10 || ch == 13) break;
			else System.out.println((char)ch);
		} while (true);
		System.out.println("end");
	}

}
