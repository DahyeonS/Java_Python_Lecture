package emspkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface DepartmentDAO {
	List<DepartmentDTO> DepartmentList();
	boolean SearchDepartment(DepartmentDTO dto);
	void InsertDepartment(DepartmentDTO dto);
	
	Connection getConnection();
	void close(ResultSet rs, PreparedStatement pstmt, Connection conn);
	void close(PreparedStatement pstmt, Connection conn);
}
