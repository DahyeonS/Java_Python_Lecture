# JDBC
데이터베이스에 연결 및 작업을 하기 위한 자바 표준 인터페이스

### JDBC 드라이버 Build Path 설정
Java Project > Properties > Java Build Path > Libraies > Add External JARS > 드라이버파일 등록

### 1. 참조변수 설정


## 정리
```java
// 1. 참조변수 설정
Connection conn = null; // 드라이버 연결
Statement stmt = null; // SQL 쿼리 실행
ResultSet rs = null; // SQL 쿼리 결과물
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
