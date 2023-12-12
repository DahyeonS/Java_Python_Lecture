# MyBatis
- 데이터베이스 처리를 Java가 아닌 XML로 처리
- XML 방식, 인터페이스 방식 2가지로 나뉨

## 실행 과정
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

### Java
#### SQLSession 설정
```java
public class SqlSessionManager {
    public static SqlSessionFactory sqlSession;
    
    static {
    	String config = "member/mybatis/mybatis-config.xml";
        Reader reader = null;
        
        try {
            reader = Resources.getResourceAsReader(config);
            sqlSession = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }       
    }
    
    public static SqlSessionFactory getSqlSession() {
        return sqlSession;
    }
}
```

### XML
- {}는 쿼리문에 동적으로 삽입될 변수(SQL Injection을 방지하기 위해 #{} 형태를 씀)
- <![CDATA[ ]]>는 태그, 특수문자 등을 문자열로 인식하게 함
```xml
<mapper namespace="memberxml">
    <select id="getMember" resultType="memberDTO">
        <![CDATA[
        select idx, id, pw, name, role, regdate from member where id = #{id}
        ]]>
    </select>
    
    <select id="getMemberList" resultType="memberDTO">
        <![CDATA[
        select idx, id, pw, name, role, regdate from member order by idx desc 
        ]]>
    </select>     
    
    <insert id="insert" parameterType="memberDTO">
        insert into member(id, pw, name, role) values (#{id}, #{pw}, #{name}, #{role})        
    </insert>

    <update id="update" parameterType="memberDTO">
        update member set pw = #{pw}, name = #{name}, role = #{role} where id = #{id}
    </update>

    <delete id="delete" parameterType="memberDTO">
        delete from member where id = #{id}
    </delete> 
    
    <select id="getMemberSearchNameList" parameterType="memberDTO" resultType="memberDTO">
        <![CDATA[
        select idx, id, pw, name, role, regdate from member where 1 = 1
        ]]>
        <if test="name != null"> <!-- 조건문을 사용해서 쿼리문을 변경 가능 -->
            and name like CONCAT('%',#{name},'%')
        </if>
        <![CDATA[
        order by idx desc
        ]]>
    </select>  
</mapper>
```

## 처리 방식
### XML 방식
DAO - XML 연동으로 처리
#### 변수 설정
```java
SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession(); // SQL 연결
SqlSession sqlSession = sqlSessionFactory.openSession(true); // SQL 세션 관리 (true는 오토커밋)
```
#### 메소드 실행
```java
sqlSession.selectOne("memberxml.getMember", dto); // SELECT(단일 갯수)
sqlSession.selectList("memberxml.getMemberList"); // SELECT(다수)
sqlSession.insert("memberxml.insert", dto); // INSERT
sqlSession.update("memberxml.update", dto); // UPDATE
sqlSession.delete("membermapper.delete", dto); // DELETE
```

### 인터페이스 방식
#### Java
```java

```
