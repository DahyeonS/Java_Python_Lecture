package jdbcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//			String sql = "select count(*) cnt from country"; // 쿼리 작성
			String sql = "select code, name, population from country";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // 쿼리 실행
			
//			ResultSet: getXXX("컬럼명")
//			스크링컬럼: getString("컬럼명")
//			정수형컬럼: getInt("컬럼명")
//			날짜형컬럼: getDate("컬럼명")
//			while (rs.next()) System.out.println("Count: " + rs.getInt("cnt"));
//			if (rs.next()) System.out.println("Count: " + rs.getInt(1)); // 칼럼명을 정하지 않았을 때
			Map<String, String> country = new HashMap<String, String>();
			List<Map<String, String>> countryList = new ArrayList<Map<String,String>>();
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				String population = rs.getInt("population") + "";
				country.put("code", code);
				country.put("name", name);
				country.put("population", population);
				countryList.add(country);
				/*
				System.out.print("Code: " + rs.getString("code") + ", ");
				System.out.print("Name: " + rs.getString("name") + ", ");
				System.out.print("Population: " + rs.getInt("population"));
				System.out.println();
				System.out.println("===============================================");
				*/
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
