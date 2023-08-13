package iopkg;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		FileWriter fw = null;
		String msg = "FileWriter 테스트입니다. \r\n";
		
		String path = "C:/kdigital2307/data/fileWriter.txt";
		
		try {
			fw = new FileWriter(path);
			fw.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
