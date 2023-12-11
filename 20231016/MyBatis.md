# MyBatis
- 데이터베이스 처리를 Java가 아닌 XML로 처리
- XML 방식, 인터페이스 방식 2가지로 나뉨

### pom.xml 설정
```xml
<dependencies>
	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis</artifactId>
	    <version>3.5.13</version>
	</dependency>
</dependencies>
```

### mybatis.conifg.xml 설정
#### *typeAlias*
MyBatis에서 사용할 Type의 별칭을 설정
```xml
<typeAliases>
    <typeAlias alias="memberDTO" type="member.dto.MemberDTO" />
</typeAliases>
```
#### *environment*
데이터베이스 연결 설정
```xml
<environments default="develpment">
    <environment id="develpment">
        <transactionManager type="JDBC" />
        <dataSource type="POOLED">
            <property name="driver" value="com.mysql.cj.jdbc.Driver" /> <!-- 데이터베이스 드라이버 -->
            <property name="url" value="jdbc:mysql://localhost:3306/javaweb" /> <!-- 데이터베이스 위치 -->
            <property name="username" value="root" /> <!-- 유저명 -->
            <property name="password" value="rpass" /> <!-- 비밀번호 -->
        </dataSource>
    </environment>
</environments>
```
#### *mapper*
SQL 쿼리문을 저장한 파일과 연동
```xml
<mappers>
    <mapper resource="member/mybatis/mapper/member.xml"/>
    <mapper resource="member/mybatis/mapper/MemberMapper.xml"/>
</mappers>
```

## XML 방식
### Java
#### 변수 설정
```java
SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession(); // SQL 연결
SqlSession sqlSession = sqlSessionFactory.openSession(true); // SQL 세션 관리 (true는 AutoCommit)
```
#### 메소드 실행
```java
sqlSession.selectOne("memberxml.getMember", dto); // SELECT(단일 갯수)
sqlSession.selectList("memberxml.getMemberList"); // SELECT(다수)
sqlSession.insert("memberxml.insert",dto); // INSERT
sqlSession.update("memberxml.update",dto); // UPDATE
sqlSession.delete("membermapper.delete",dto); // DELETE
```

### XML
```xml

```

## 인터페이스 방식
### Java
```java

```

### XML
```xml

```