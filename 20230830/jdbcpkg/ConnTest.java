package jdbcpkg;

import java.sql.Connection;

public class ConnTest {

	public static void main(String[] args) {
//		1. 연결에 사용할 참조변수 생성
		Connection conn = null;
//		2. 드라이버 로딩
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
