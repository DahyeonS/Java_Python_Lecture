# JSP DB연결

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
```jsp

```