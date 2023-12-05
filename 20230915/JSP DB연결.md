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
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
List<MemberDTO> list = new ArrayList<MemberDTO>();

try {
	String driver = "com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	
	String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";
	String user = "root";
	String password = "rpass";
	
	conn = DriverManager.getConnection(url, user, password);
	out.print("Conn OK!! <br>");
	
	String sql = "select * from member order by idx desc";
	pstmt = conn.prepareStatement(sql);
	
	rs = pstmt.executeQuery();
	while (rs.next()) {
		String id = rs.getString("id");
    	String pw = rs.getString("pw");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		MemberDTO dto = null;
		
		dto = new MemberDTO(id, pw, name, age);
		list.add(dto);
	}
} catch (Exception e) {
	e.printStackTrace();
} finally {
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