package iopkg;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {
	
	public static void main(String[] args) {
		byte[] data = {10, 20, 30, 40};
		ByteArrayInputStream bai = new ByteArrayInputStream(data);
		
		int ch = -1;
		while ((ch = bai.read()) != -1) {
			System.out.println(ch);
		}
	}
	
}
