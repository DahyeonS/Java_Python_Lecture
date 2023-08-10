package iopkg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadAddressFin {

	public static void main(String[] args) {
//		Reader 뚫기
		FileReader fr = null;
//		한 줄씩 읽기 
		BufferedReader bfr = null;
//		문자열을 특정 구분자로 나누어진 데이터 > 토큰
		StringTokenizer st = null;
		
		String path = "C:/kdigital2307/data/address.txt";
		try {
			fr = new FileReader(path);
			bfr = new BufferedReader(fr);
			
			String str = null;
			List<String> addressList = new ArrayList<String>();
//			file read -> ArrayList
			while (true) {
				str = bfr.readLine();
				if (str == null) break;
				addressList.add(str);
			}
			
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
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
