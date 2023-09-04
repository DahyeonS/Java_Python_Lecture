package emspkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface EmsDAO {
//	1번
	boolean SearchDepartment(DepartmentDTO dto);
	void InsertDepartment(DepartmentDTO dto);
	List<DepartmentDTO> DepartmentList();
	
//	2번
	boolean CheckDeptId(int deptid);
	boolean CheckStudentId(int id);
	void InsertStudent(StudentDTO dto);
	void StudentList();
	
//	3번
	boolean CheckProfessorID(int id);
	void InsertProfessor(ProfessorDTO dto);
	void ProfessorList();
	
//	4번
	boolean CheckCourseID(int id);
	void InsertCourse(CourseDTO dto);
	void CourseList();
	
//	5번
	void RegisterList(int sid);
	boolean CheckRegister(RegisterDTO dto);
	void RegisterCourse(RegisterDTO dto);
	
//	DB 연결
	Connection getConnection();
	void close(ResultSet rs, PreparedStatement pstmt, Connection conn);
	void close(PreparedStatement pstmt, Connection conn);
}
