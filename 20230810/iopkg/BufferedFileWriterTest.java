package iopkg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriterTest {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		String path = "C:/kdigital2307/data/fileWriter.txt";
		
		try {
			fw = new FileWriter(path);
			bw = new BufferedWriter(fw, 4);
			bw.write('A');
			bw.newLine();
			bw.write("bbb\r\n");
			bw.write('C');
			bw.newLine();
			bw.write('D');
			bw.write('E');
			bw.write('F');
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
