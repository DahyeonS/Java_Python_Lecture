package jdbcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("== 메뉴 선택 ==");
			System.out.println("1. 회원 목록 보기");
			System.out.println("2. 회원 가입");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("9. 끝내기");
			
			int command = sc.nextInt();
			
//			Start
			switch (command) {
				case 1 :
					System.out.println("1. 회원 목록 보기");
					
//					1. conn
					Connection conn = null;
					String driver = "com.mysql.cj.jdbc.Driver";
					try {
						Class.forName(driver);
						String url = "jdbc:mysql://localhost:3306/world?ServerTimezone=UTC";
						String user = "root";
						String password = "rpass";
						conn = DriverManager.getConnection(url, user, password);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 2 :
					break;
					
				case 3 :
					break;
					
				case 4 :
					break;
			}
//			End
			if (command == 9) break;
		}
		sc.close();
	}

}