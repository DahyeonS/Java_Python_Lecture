package jdbcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnTest {

	public static void main(String[] args) {
//		1. 참조변수 설정
		Connection conn = null; // 드라이버 연결
		Statement stmt = null; // SQL 쿼리 실행
		ResultSet rs = null; // SQL 쿼리 결과물
		try {
//		2. 드라이버 로딩
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
//		3. DB 연결
//			String url = "jdbc:mysql://localhost:3306/kdigital2307";
//			url += "?ServerTimezone=UTC";
//			String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";
			
			String url = "jdbc:mysql://localhost:3306/world?ServerTimezone=UTC";
			String user = "root";
			String password = "rpass";
			conn = DriverManager.getConnection(url, user, password);
			
//			System.out.println("Connection OK!!"); // 연결 여부
			
//		4. SQL 창 + 실행
			String sql = "select count(*) from country"; // 쿼리 작성
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // 쿼리 실행
			
//			ResultSet: getXXX("컬럼명")
//			스크링컬럼: getString("컬럼명")
//			정수형컬럼: getInt("컬럼명")
//			날짜형컬럼: getDate("컬럼명")
			while (rs.next()) System.out.println("Count: " + rs.getInt(1));
//			if (rs.next()) System.out.println("Count: " + rs.getInt(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
