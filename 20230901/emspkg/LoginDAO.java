package emspkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface LoginDAO {
	
	void LoginInsert(LoginDTO dto);
	void LoginDelete(LoginDTO dto);
	
	boolean Login(LoginDTO dto);
	boolean LoginIndex(String id);
	String PwCheck(String id);
	
	Connection getConnection();
	void close(ResultSet rs, PreparedStatement pstmt, Connection conn);
	void close(PreparedStatement pstmt, Connection conn);
}
