package jdbcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTest {

	public static void main(String[] args) {
//		1. 참조변수 설정
		Connection conn = null;
		try {
//		2. 드라이버 로딩
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
//		3. DB 연결
//			String url = "jdbc:mysql://localhost:3306/kdigital2307";
//			url += "?ServerTimezone=UTC";
			String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";
			String user = "root";
			String password = "rpass";
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection OK!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
