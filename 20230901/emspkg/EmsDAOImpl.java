package emspkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmsDAOImpl implements EmsDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	
//	DB 연결
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

//	1번
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deptList;
	}

//	2번
	@Override
	public boolean CheckDeptId(int deptid) {
		conn = getConnection();
		sql = "select * from department where department_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptid);
			
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
	public boolean CheckStudentId(int id) {
		conn = getConnection();
		sql = "select * from student where student_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
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
	public void InsertStudent(StudentDTO dto) {
		conn = getConnection();
		sql = "insert into student values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getHeight());
			pstmt.setInt(4, dto.getDeptid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}

	@Override
	public void StudentList() {
		conn = getConnection();
		sql = "select student_id, student_name, height, s.department_id, department_name from student s, department d where s.department_id = d.department_id";
		System.out.println("<학생 목록>");
		System.out.println("================================");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("student_id");
				String name = rs.getString("student_name");
				int height = rs.getInt("height");
				int deptno = rs.getInt("s.department_id");
				String dname = rs.getString("department_name");
				
				System.out.println("학생ID: " + id + " / 학생 이름: " + name + " / 신장: " + height + " / 학과 번호: " + deptno + " / 학과: " + dname);
				System.out.println("================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
	}

//	3번
	@Override
	public boolean CheckProfessorID(int id) {
		conn = getConnection();
		sql = "select * from professor where professor_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
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
	public void InsertProfessor(ProfessorDTO dto) {
		conn = getConnection();
		sql = "insert into professor values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getDeptid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}

	@Override
	public void ProfessorList() {
		conn = getConnection();
		sql = "select professor_id, professor_name, department_name from professor p, department d where p.department_id = d.department_id";
		System.out.println("<교수 목록>");
		System.out.println("================================");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("professor_id");
				String name = rs.getString("professor_name");
				String dname = rs.getString("department_name");
				
				System.out.println("교수ID: " + id + " / 교수 이름: " + name + " / 학과: " + dname);
				System.out.println("================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
	}

//	4번
	@Override
	public boolean CheckCourseID(int id) {
		conn = getConnection();
		sql = "select * from course where course_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
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
	public void InsertCourse(CourseDTO dto) {
		conn = getConnection();
		sql = "insert into course values (?, ?, date_format(?, \"%Y-%m-%d\"), date_format(?, \"%Y-%m-%d\"), ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getStart());
			pstmt.setString(4, dto.getEnd());
			pstmt.setInt(5, dto.getProfid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}

	@Override
	public void CourseList() {
		conn = getConnection();
		sql = "select course_id, course_name, start_date, end_date, professor_name from course c, professor p where c.professor_id = p.professor_id";
		System.out.println("<과목 목록>");
		System.out.println("================================");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("course_id");
				String name = rs.getString("course_name");
				String start = rs.getDate("start_date") + "";
				String end = rs.getDate("end_date") + "";
				String profname = rs.getString("professor_name");
				
				System.out.println("과목ID: " + id + " / 과목명: " + name + " / 개강일자: " + start + " / 종강일자: " + end + " / 교수 이름: " + profname);
				System.out.println("================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
	}
	
//	5번
	@Override
	public void RegisterList(int sid) {
		conn = getConnection();
		sql = "select s.student_id, student_name, course_name from student_course sc, student s, course c where sc.student_id = s.student_id and sc.course_id = c.course_id";
		sql += " and s.student_id = ?";
		System.out.println("<수상 신청 목록>");
		System.out.println("================================");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sid = rs.getInt("s.student_id");
				String sname = rs.getString("student_name");
				String cname = rs.getString("course_name");
				
				System.out.println("학생ID: " + sid + " / 학생 이름: " + sname + " / 수강 과목: " + cname);
				System.out.println("================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
	}
	

	@Override
	public boolean CheckRegister(RegisterDTO dto) {
		conn = getConnection();
		sql = "select * from student_course where student_id = ? and course_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSid());
			pstmt.setInt(2, dto.getCid());
			
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
	public void RegisterCourse(RegisterDTO dto) {
		conn = getConnection();
		sql = "insert into student_course values (?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSid());
			pstmt.setInt(2, dto.getCid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}

}
