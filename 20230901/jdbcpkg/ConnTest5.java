package jdbcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnTest5 {

	public static void main(String[] args) {
//		1. 참조변수 설정
		Connection conn = null; // 드라이버 연결
		PreparedStatement stmt = null; // SQL 쿼리 실행
		ResultSet rs = null; // SQL 쿼리 결과물
		try {
//		2. 드라이버 로딩
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
//		3. DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn ok!!");
//		4. SQL 창 + 실행
			String sql = "select * from dept";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(); // 쿼리 실행
			while (rs.next()) {
				String deptno = rs.getString("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + " / " + dname + " / " + loc);
			}
			
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
