package iopkg;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		FileOutputStream fo = null;
		
		String msg = "FileOutputStream Test";
		byte[] byteMsg = msg.getBytes();
		
		String path = "C:/kdigital2307/data/fileoutput.txt";
		
		try {
			fo = new FileOutputStream(path);
			fo.write(byteMsg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
