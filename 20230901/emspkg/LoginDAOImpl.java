package emspkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
	@Override
	public Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";
			String user = "root";
			String password = "rpass";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	@Override
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void LoginInsert(LoginDTO dto) {
		conn = getConnection();
		sql = "insert into login values (?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}

	@Override
	public boolean LoginIndex(String id) {
		conn = getConnection();
		sql = "select * from login where id like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return false;
	}

	@Override
	public void LoginDelete(LoginDTO dto) {
		conn = getConnection();
		sql = "delete from login where id like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}

	@Override
	public String PwCheck(String id) {
		conn = getConnection();
		sql = "select pw from login where id like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) return rs.getString("pw");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return null;
	}

	@Override
	public boolean Login(LoginDTO dto) {
		conn = getConnection();
		sql = "select * from login where id like ? and pw like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			
			rs = pstmt.executeQuery();
			if (rs.next()) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return false;
	}

}
