package iopkg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadAddress {

	public static void main(String[] args) {
//		byte로 뚫고
		FileInputStream fi = null;
//		reader로 변환
		InputStreamReader isr = null;
//		한 줄씩 읽기 
		BufferedReader bfr = null;
//		문자열을 특정 구분자로 나누어진 데이터 > 토큰
		StringTokenizer st = null;
		
		String path = "C:/kdigital2307/data/address.txt";
		try {
			fi = new FileInputStream(path);
			isr = new InputStreamReader(fi);
			bfr = new BufferedReader(isr);
			
			String str = null;
			List<String> addressList = new ArrayList<String>();
//			file read -> ArrayList
			while (true) {
				str = bfr.readLine(); // 세종대왕,한양,king@e.com,010
				if (str == null) break;
				addressList.add(str);
			}
//			addr.split(",");
			
			for (String address : addressList) {
				st = new StringTokenizer(address, ",");
				String name = st.nextToken();
				String addr = st.nextToken();
				String email = st.nextToken();
				String tel = st.nextToken();
				String fm = "name: %s, addr: %s, email: %s, tel: %s\n";
				System.out.printf(fm, name, addr, email, tel);
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
