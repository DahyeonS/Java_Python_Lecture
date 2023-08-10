package iopkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fIn = null;
		
		String path = "C:/kdigital2307/data/test.txt";
		try {
			fIn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int ch = -1;
		try {
			while ((ch = fIn.read()) != -1) {
				System.out.print((char)ch + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
