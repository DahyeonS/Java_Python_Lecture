package com.myweb.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	private Connection getConnection() {
		Connection conn = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			
			String dbname = "javaweb";	
			String url = "jdbc:mysql://localhost:3306/"+dbname+"?ServerTimezone=UTC";
			String user = "root";
			String password = "rpass";
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(MemberDTO dto) {
		int rs = 0;
		
		conn = getConnection();
		sql = "INSERT INTO member (id, pw, name, role) VALUES (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getRole());
			
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return rs;
	}

	@Override
	public MemberDTO getMember(MemberDTO dto) {
		MemberDTO retDto = null;
		
		conn = getConnection();
		sql = "SELECT idx, id, pw, name, role, regdate FROM member WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String role = rs.getString("role");
				String regdate = rs.getString("regdate");
				
				retDto = new MemberDTO(idx, id, pw, name, role, regdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return retDto;
	}

	@Override
	public int update(MemberDTO dto) {
		int rs = 0;
		
		conn = getConnection();
		sql = "UPDATE member SET name = ?, role = ? WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getRole());
			pstmt.setString(3, dto.getId());
			
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		return rs;
	}
}
