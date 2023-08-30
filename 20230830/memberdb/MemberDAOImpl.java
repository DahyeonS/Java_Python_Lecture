package memberdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<MemberDTO> readmembers() {
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		
//		1. conn
		conn = JDBCUtil.getConnection();
		
//		2. statement, execute
//		String sql = "select * from member";
		String sql = "select id, pw, name, age from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				MemberDTO dto = new MemberDTO(id, pw, name, age);
				members.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return members;
	}
	
	void writeMembers(MemberDTO member) {
//		1. conn
		conn = JDBCUtil.getConnection();
		
//		2. statement, execute
		String sql = "insert into member(id, pw, name, age) values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			
			pstmt.executeUpdate(); // return 값이 업데이트 성공한 수
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public int memberIndex(String id) {
		System.out.println(id);
		List<MemberDTO> m = readmembers();
		for (int i=0; i<m.size(); i++) {
			if (id.equals(m.get(i).getId())) return i;
		}
		return -1;
	}
		
	@Override
	public List<MemberDTO> memberList() {
		return readmembers();
	}
	
	@Override
	public void memberInsert(MemberDTO member) {
		System.out.println(member);
		writeMembers(member);
	}

	@Override
	public void memberUpdate(int index, MemberDTO member) {
		conn = JDBCUtil.getConnection();
		String sql = "update member set pw = ?, name = ?, age = ? where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, member.getAge());
			pstmt.setString(4, member.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	@Override
	public void memberDelete(String id) {
		conn = JDBCUtil.getConnection();
		String sql = "delete from member where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
}
