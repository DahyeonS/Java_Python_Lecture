package jdbcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberMain {
	
	static Connection getConnection() {
//		1. conn
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("== 메뉴 선택 ==");
			System.out.println("1. 회원 목록 보기");
			System.out.println("2. 회원 가입");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 회원 이름으로 검색");
			System.out.println("6. 회원 이름으로 모두 검색");
			System.out.println("9. 끝내기");
			
			int command = sc.nextInt();
			
//			Start
			switch (command) {
				case 1 :
					System.out.println("1. 회원 목록 보기");
					
//					1. conn
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					String driver = "com.mysql.cj.jdbc.Driver";
					try {
						Class.forName(driver);
						String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";
						String user = "root";
						String password = "rpass";
						conn = DriverManager.getConnection(url, user, password);
						
//					2. SQL
						String sql = "select * from member";
						pstmt = conn.prepareStatement(sql);
						
						List<MemberDTO> members = new ArrayList<MemberDTO>();
						rs = pstmt.executeQuery();
						while (rs.next()) {
							/*
							System.out.print(rs.getInt("idx") + " / ");
							System.out.print(rs.getString("id") + " / ");
							System.out.print(rs.getString("pw") + " / ");
							System.out.print(rs.getString("name") + " / ");
							System.out.print(rs.getInt("age") + " / ");
							System.out.println(rs.getString("regdate"));
							System.out.println("=====================================================");
							*/
							
							String id = rs.getString("id");
							String pw = rs.getString("pw");
							String name = rs.getString("name");
							int age = rs.getInt("age");
							MemberDTO dto = new MemberDTO(id, pw, name, age);
							members.add(dto);
						}
						for (MemberDTO m : members) {
							System.out.print(m.getId() + " / ");
							System.out.print(m.getPw() + " / ");
							System.out.print(m.getName() + " / ");
							System.out.println(m.getAge());
							System.out.println("================================");
						}
						
					} catch (Exception e) {
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
					break;
					
				case 2 :
					System.out.println("2. 회원 가입");
					
//					1. conn
					conn = null;
					pstmt = null;
					
					driver = "com.mysql.cj.jdbc.Driver";
					try {
						Class.forName(driver);
						String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";
						String user = "root";
						String password = "rpass";
						conn = DriverManager.getConnection(url, user, password);
//						회원 정보 입력
						System.out.print("ID 입력 > ");
						String id = sc.next();
						System.out.print("Password 입력 > ");
						String pw = sc.next();
						System.out.print("Name 입력 > ");
						String name = sc.next();
						System.out.print("Age 입력 > ");
						int age = sc.nextInt();
							
//					2. SQL
						String sql = "insert into member(id, pw, name, age) values ";
						sql += "(?, ?, ?, ?)";
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setString(1, id);
						pstmt.setString(2, pw);
						pstmt.setString(3, name);
						pstmt.setInt(4, age);
						
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
					break;
					
				case 3 :
					System.out.println("3. 회원 정보 수정");
					
					conn = null;
					pstmt = null;
					rs = null;
					
					conn = MemberMain.getConnection();

//					ID 검색으로 사용자가 있다면 수정
					try {
						System.out.print("ID 입력 > ");
						String id = sc.next();
						String sql = "select * from member where id = ?";
						
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setString(1, id);
						rs = pstmt.executeQuery();
						id = null;
						
						if (rs.next()) id = rs.getString("id");
						
						if (id != null) {
//						수정 정보 입력
							System.out.print("Password 입력 > ");
							String pw = sc.next();
							System.out.print("Name 입력 > ");
							String name = sc.next();
							System.out.print("Age 입력 > ");
							int age = sc.nextInt();
								
//						2. SQL
							sql = "update member set pw = ?, name = ?, age = ? where id = ?";
							try {
								pstmt = conn.prepareStatement(sql);
								
								pstmt.setString(1, pw);
								pstmt.setString(2, name);
								pstmt.setInt(3, age);
								pstmt.setString(4, id);
								
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
						}
						else {
							System.out.println("Member Not Found!!");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 4 :
					System.out.println("4. 회원 삭제");
					
					conn = null;
					pstmt = null;
					rs = null;
					
					conn = MemberMain.getConnection();

//					ID 검색으로 사용자가 있다면 수정
					System.out.print("ID 입력 > ");
					try {
						String id = sc.next();
						String sql = "select * from member where id = ?";
						
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setString(1, id);
						rs = pstmt.executeQuery();
						id = null;
						
						if (rs.next()) id = rs.getString("id");
						
						if (id != null) {
//						2. SQL
							sql = "delete from member where id = ?";
							try {
								pstmt = conn.prepareStatement(sql);
								
								pstmt.setString(1, id);
								
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
						else {
							System.out.println("Member Not Found!!");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 5 :
					System.out.println("5. 회원 이름으로 검색");
					
					conn = null;
					pstmt = null;
					rs = null;
					
					conn = MemberMain.getConnection();

//					이름 입력으로 사용자가 있다면 검색
					try {
						System.out.print("이름 입력 > ");
						String name = sc.next();
						String sql = "select * from member where name = ?";
						
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setString(1, name);
						rs = pstmt.executeQuery();
						name = null;
						
						if (rs.next()) name = rs.getString("name");
						
						if (name != null) {
//						2. SQL
							sql = "select * from member where name like ? limit 1";
							try {
								pstmt = conn.prepareStatement(sql);
								
								pstmt.setString(1, name);
								
								List<MemberDTO> members = new ArrayList<MemberDTO>();
								rs = pstmt.executeQuery();
								while (rs.next()) {
									String id = rs.getString("id");
									String pw = rs.getString("pw");
									name = rs.getString("name");
									int age = rs.getInt("age");
									MemberDTO dto = new MemberDTO(id, pw, name, age);
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
						else {
							System.out.println("Member Not Found!!");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
					
				case 6 :
					conn = null;
					pstmt = null;
					rs = null;
					
					conn = MemberMain.getConnection();

//					이름 입력으로 사용자가 있다면 검색
					try {
						System.out.print("이름 입력 > ");
						String name = sc.next();
						String sql = "select * from member where name like ?";
						
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setString(1, name);
						rs = pstmt.executeQuery();
						name = null;
						
						if (rs.next()) name = rs.getString("name");
						
						if (name != null) {
//						2. SQL
							sql = "select * from member where name = ?";
							try {
								pstmt = conn.prepareStatement(sql);
								
								pstmt.setString(1, name);
								
								List<MemberDTO> members = new ArrayList<MemberDTO>();
								rs = pstmt.executeQuery();
								while (rs.next()) {
									String id = rs.getString("id");
									String pw = rs.getString("pw");
									name = rs.getString("name");
									int age = rs.getInt("age");
									MemberDTO dto = new MemberDTO(id, pw, name, age);
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
						else {
							System.out.println("Member Not Found!!");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
			}
//			End
			if (command == 9) break;
		}
		sc.close();
	}

}