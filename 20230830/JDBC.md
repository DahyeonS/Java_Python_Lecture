# JDBC
데이터베이스에 연결 및 작업을 하기 위한 자바 표준 인터페이스

### 0. JDBC 드라이버 Build Path 설정
Java Project > Properties > Java Build Path > Libraies > Add External JARS > 드라이버파일 등록

### 1. 참조변수 설정
```java
Connection conn = null; // 드라이버 연결
Statement stmt = null; // SQL 쿼리 실행(Statement)
PreparedStatement stmt = null; // SQL 쿼리 실행(PreparedStatement)
ResultSet rs = null; // SQL 쿼리 결과물
```

### 2. 드라이버 로딩
```java
String driver = "com.mysql.cj.jdbc.Driver"; // MySQL 연결용 드라이버 로드
Class.forName(driver);
```

### 3. 데이터베이스 연결
```java
// url 작성
String url = "jdbc:mysql://localhost:3306/kdigital2307";
url += "?ServerTimezone=UTC";

String url = "jdbc:mysql://localhost:3306/kdigital2307?ServerTimezone=UTC";

// DB 연결 계정 설정
String user = "root"; // 계정명
String password = "rpass"; // 비밀번호

// 데이터베이스 연동
conn = DriverManager.getConnection(url, user, password);
```

### 4. SQL창 + 실행
#### SELECT
```java
// Statement
String sql = "select count(*) cnt from country"; // 쿼리 작성
stmt = conn.createStatement();
rs = stmt.executeQuery(sql); // 쿼리 실행


// PreparedStatement
String param = "KOR";
String sql = "select code, name, population from country";
sql += " where code = ?";
			
stmt = conn.prepareStatement(sql);
stmt.setString(1, param); // ?에 KOR 세팅
rs = stmt.executeQuery(); // 쿼리 실행

// ArrayList에 저장
Map<String, String> country = new HashMap<String, String>();
List<Map<String, String>> countryList = new ArrayList<Map<String,String>>();
while (rs.next()) {
  String code = rs.getString("code");
  String name = rs.getString("name");
  String population = rs.getInt("population") + "";
  country.put("code", code);
  country.put("name", name);
  country.put("population", population);
  countryList.add(country);
}

// Class로 생성한 변수에 저장
CountryDto country = null;
List<CountryDto> countryList = new ArrayList<CountryDto>();
while (rs.next()) {
  String code = rs.getString("code");
	String name = rs.getString("name");
	String population = rs.getInt("population") + "";
	country = new CountryDto(code, name, population);
	countryList.add(country);
}
```

#### UPDATE
```java
// 데이터베이스 연결
conn = JDBCUtil.getConnection(); // 드라이버 로드 후 데이터베이스에 연결하는 메서드 호출

// 쿼리 작성
String sql = "insert into member(id, pw, name, age) values (?, ?, ?, ?)";

// SQL 실행
try {
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, member.getId());
  pstmt.setString(2, member.getPw());
  pstmt.setString(3, member.getName());
  pstmt.setInt(4, member.getAge());
			
  pstmt.executeUpdate(); // UPDATE 작업 실행문, return 값이 업데이트 성공한 수
} catch (SQLException e) {
  e.printStackTrace();
} finally {
  JDBCUtil.close(pstmt, conn); // 세션을 닫는 메서드 호출
}
```

#### DELETE
```java
// 데이터베이스 연결
conn = JDBCUtil.getConnection(); // 드라이버 로드 후 데이터베이스에 연결하는 메서드 호출

// 쿼리 작성
String sql = "delete from member where id = ?";

// SQL 실행		
try {
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, id);

  pstmt.executeUpdate(); // DELETE 작업 실행문
} catch (SQLException e) {
  e.printStackTrace();
} finally {
  JDBCUtil.close(pstmt, conn); // 세션을 닫는 메서드 호출
}
```

## 정리
```java
// 1. 참조변수 설정
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try {
// 2. 드라이버 로딩
  String driver = "com.mysql.cj.jdbc.Driver";
  Class.forName(driver);

// 3. DB 연결
  String url = "jdbc:mysql://localhost:3306/world?ServerTimezone=UTC";
  String user = "root";
  String password = "rpass";
  conn = DriverManager.getConnection(url, user, password);

// 4. SQL 창 + 실행
  String sql = "select code, name, population from country";
  stmt = conn.createStatement();
  rs = stmt.executeQuery(sql); // 쿼리 실행

  Map<String, String> country = new HashMap<String, String>();
  List<Map<String, String>> countryList = new ArrayList<Map<String,String>>();
  while (rs.next()) {
    String code = rs.getString("code");
    String name = rs.getString("name");
    String population = rs.getInt("population") + "";
    country.put("code", code);
    country.put("name", name);
    country.put("population", population);
    countryList.add(country);
  }
} catch (Exception e) {
    e.printStackTrace();
} finally {
  try {
    if(rs != null) rs.close();
    if(stmt != null) stmt.close();
    if(conn != null) conn.close();
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
```
