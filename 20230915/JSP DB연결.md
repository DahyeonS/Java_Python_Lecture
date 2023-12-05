# JSP DB연결
## 연결 방법
1. 메이븐 프로젝트로 변환하여 pom.xml 생성
2. pom.xml에서 DB 관련 의존성 추가
```xml
<dependencies>
    <!-- MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
	</dependency>
	
    <!-- Oracle -->
    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc11</artifactId>
        <version>23.2.0.0</version>
	</dependency>
</dependencies>
```
3. Java를 이용해서 데이터베이스 연결
```java
Connection conn = null; // DB 연결
PreparedStatement pstmt = null; // 쿼리
ResultSet rs = null; // 요청받은 DB 데이터
List<MemberDTO> list = new ArrayList<MemberDTO>(); // DB 데이터를 담을 리스트

try { // try-catch문으로 처리
	String driver = "com.mysql.cj.jdbc.Driver"; // SQL 드라이버(MySQL, 오라클 등)
	Class.forName(driver);
	
    // "jdbc:SQL종류://연결포트/데이터베이스?ServerTimezone=UTC"
	String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC"; // DB 접속 주소
	String user = "root"; // 사용자명
	String password = "rpass"; // 비밀번호
	
	conn = DriverManager.getConnection(url, user, password); // DB 연결
	out.print("Conn OK!! <br>");
	
	String sql = "select * from member order by idx desc"; // 쿼리 작성
	pstmt = conn.prepareStatement(sql); // 쿼리 실행
	
	rs = pstmt.executeQuery(); // 쿼리 결과물 요청
	while (rs.next()) {
		String id = rs.getString("id");
    	String pw = rs.getString("pw");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		MemberDTO dto = null;
		
		dto = new MemberDTO(id, pw, name, age);
		list.add(dto); // 쿼리 결과값 저장
	}
} catch (Exception e) {
	e.printStackTrace();
} finally { // 작업 후 DB 연결 종료
	try {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
```

## DB 작업
DAO에서 작업

### *연결 메소드*
```java
// DB 연결
private Connection getConnection() {
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

// DB 연결 종료
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
```

## executeQuery
- SELECT문이 해당
- 결과값을 오브젝트로 반환

### *전체 검색*
```java
public List<MemberDTO> getMemberList() {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<MemberDTO> list = new ArrayList<MemberDTO>();
	
	try {
		conn = getConnection();
		
		String sql = "select * from member order by idx desc"; // 전체 검색
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String idx = rs.getString("idx");
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String regdate = rs.getString("regdate");
			
			MemberDTO dto = new MemberDTO(idx, id, pw, name, age, regdate);
			list.add(dto);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(conn, pstmt, rs);
	}
	return list; // 결과 반환
}
```

### *조건 검색*
```java
public MemberDTO getMember(MemberDTO dto) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberDTO retDto = null;
	
	try {
		conn = getConnection();
		
		String sql = "select pw, name, age from member where id = ?"; // 조건 검색
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String id = dto.getId();
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			
			retDto = new MemberDTO(id, pw, name, age);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(conn, pstmt, rs);
	}
	return retDto; // 결과 반환
}
```

## executeUpdate
- INSERT, UPDATE, DELETE문이 해당
- 결과값을 정수(변경된 줄 갯수)로 반환
```java
public int update(MemberDTO dto) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	int rs = 0;
	
	try {
		conn = getConnection();
		
		String sql = "update member set pw = ?, name = ?, age = ? where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getPw());
		pstmt.setString(2, dto.getName());
		pstmt.setInt(3, dto.getAge());
		pstmt.setString(4, dto.getId());
		
		rs = pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close(conn, pstmt);
	}
	return rs;
}
```