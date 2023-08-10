package iopkg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderTest {

	public static void main(String[] args) {
//		byte로 뚫고
		FileInputStream fi = null;
//		reader로 변환
		InputStreamReader isr = null;
//		한 줄씩 읽기 
		BufferedReader bfr = null;
		
		String path = "C:/kdigital2307/data/bufferReader.txt";
		try {
			fi = new FileInputStream(path);
			isr = new InputStreamReader(fi);
			bfr = new BufferedReader(isr);
			
			String str = null;
			while ((str = bfr.readLine()) != null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bfr.close();
				isr.close();
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
