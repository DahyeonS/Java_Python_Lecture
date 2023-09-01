package emspkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
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
	public boolean SearchDepartment(DepartmentDTO dto) {
		conn = getConnection();
		sql = "select * from department where department_id = ? or department_name like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			
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
	public void InsertDepartment(DepartmentDTO dto) {
		conn = getConnection();
		sql = "insert into department values (?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}

	@Override
	public List<DepartmentDTO> DepartmentList() {
		List<DepartmentDTO> deptList = new ArrayList<DepartmentDTO>();
		conn = getConnection();
		sql = "select * from department";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("department_id");
				String name = rs.getString("department_name");
				DepartmentDTO d = new DepartmentDTO(id, name);
				deptList.add(d);
			}
			System.out.println("학과 목록");
			System.out.println("================================");
			for (DepartmentDTO d : deptList) {
				System.out.println(d.toString());
				System.out.println("================================");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
