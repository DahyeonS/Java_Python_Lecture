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

## SELECT

## INSERT

## UPDATE

## DELETE