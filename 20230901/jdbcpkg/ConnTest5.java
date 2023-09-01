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
			String url = "jdbc:mysql://localhost:3306/world?ServerTimezone=UTC";
			String user = "root";
			String password = "rpass";
			conn = DriverManager.getConnection(url, user, password);
			
//		4. SQL 창 + 실행
			String param = "KOR";
			String sql = "select code, name, population from country";
			sql += " where code = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, param); // ?에 KOR 세팅
			rs = stmt.executeQuery(); // 쿼리 실행
			CountryDto country = null;
			List<CountryDto> countryList = new ArrayList<CountryDto>();
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				String population = rs.getInt("population") + "";
				country = new CountryDto(code, name, population);
				countryList.add(country);
			}
			for (CountryDto dto : countryList) System.out.println(dto);
			
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
