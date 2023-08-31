package jdbcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberStaticDAO {
	static void SearchMemberOne(MemberDTO dto) {
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = MemberStaticDAO.getConnection();
			
//		2. SQL
		String sql = "select * from member where name like ? limit 1";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, pw, name, age);
				members.add(dto);
			}
			System.out.println("검색 결과");
			System.out.println("================================");
			for (MemberDTO m : members) {
				System.out.print(m.getId() + " / ");
				System.out.print(m.getPw() + " / ");
				System.out.print(m.getName() + " / ");
				System.out.println(m.getAge());
				System.out.println("================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void SearchMemberList(MemberDTO dto) {
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = MemberStaticDAO.getConnection();
			
//		2. SQL
		String sql = "select * from member where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, pw, name, age);
				members.add(dto);
			}
			System.out.println("검색 결과");
			System.out.println("================================");
			for (MemberDTO m : members) {
				System.out.print(m.getId() + " / ");
				System.out.print(m.getPw() + " / ");
				System.out.print(m.getName() + " / ");
				System.out.println(m.getAge());
				System.out.println("================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void DeleteMember(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = getConnection();
		
//		2. SQL
		String sql = "delete from member where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			
			int result = pstmt.executeUpdate();
			if (result != 0) System.out.println("회원 삭제 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void UpdateMember(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		conn = getConnection();

//		수정 정보 입력
		System.out.print("Password 입력 > ");
		String pw = sc.next();
		System.out.print("Name 입력 > ");
		String name = sc.next();
		System.out.print("Age 입력 > ");
		int age = sc.nextInt();
		
//		2. SQL
		String sql = "update member set pw = ?, name = ?, age = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setString(4, dto.getId());
			
			int result = pstmt.executeUpdate();
			if (result != 0) System.out.println("회원 수정 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
	
	static void InsertMember(MemberDTO dto) {
//		1. conn
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
				
//		2. SQL
			String sql = "insert into member(id, pw, name, age) values ";
			sql += "(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			
			int result = pstmt.executeUpdate();
			if (result != 0) System.out.println("회원 가입 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static List<MemberDTO> getMemberList() {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO dto = null;
		
//		db
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = getConnection();
		
		String sql = "select * from member order by idx desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
//			dto
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, pw, name, age);
				memberList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberList;
	}
	
	
	static MemberDTO getMemberOne(String id) {
		MemberDTO dto = null;
		
//		db
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = getConnection();
		
		String sql = "select * from member where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
//			dto
			while (rs.next()) {
				id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, pw, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	static MemberDTO getMemberOneName(String name) {
		MemberDTO dto = null;
		
//		db
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = getConnection();
		
		String sql = "select * from member where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
//			dto
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, pw, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	
	static Connection getConnection() {
//		1. conn
		Connection conn = null;
		
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
}
