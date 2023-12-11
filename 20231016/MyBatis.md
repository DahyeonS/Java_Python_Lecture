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
#### typeAlias
MyBatis에서 사용할 Type의 별칭을 설정
```xml
<typeAliases>
    <typeAlias alias="memberDTO" type="member.dto.MemberDTO" />
</typeAliases>
```
####

## XML 방식
### 

## 인터페이스 방식
