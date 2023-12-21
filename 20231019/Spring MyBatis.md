# Spring MyBatis

## XML
### root-context.xml
자바가 아닌 XML 파일로 SqlSessionFactory 설정
```xml
	<!-- for mysql -->
	<bean id="dataSource"
		class="org.apache.commons.dbcp2.BasicDataSource"
		destroy-method="close">
		<property name="driverClassName"
			value="com.mysql.cj.jdbc.Driver" />
		<property name="url"
			value="jdbc:mysql://localhost:3306/javaweb?serverTimezone=UTC" />
		<property name="username" value="root" />
		<property name="password" value="rpass" />
	</bean>

	<!-- for mybatis -->
	<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation"
			value="classpath:com/myweb/mybatis/mybatis-config.xml" />
	</bean>
	<bean id="sqlSessionTemplate"
		class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory" />
	</bean>
	
	<mybatis-spring:scan base-package="com.myweb.mybatis.mapper"/> <!-- Mapper 파일의 디렉토리 설정 -->
```

### mybatis-config.xml
Type의 별칭을 설정
```xml
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" 
"https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        <typeAlias type="com.myweb.web.MemberDTO" alias="memberDTO"/>
    </typeAliases>
</configuration>
```

## Java
### Mapper
별도의 SqlSessionFactory 선언 없이 실행
```java
@Mapper
public interface MemberMapper {
	public Map<String, Object> getMember(MemberDTO dto);
}
```