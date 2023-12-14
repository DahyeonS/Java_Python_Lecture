# Spring

## 시작하기
1. Spring Legacy Project - Spring MVC Project로 프로젝트 생성
2. com.name.name 형태로 패키지 설정
3. properties의 project Facets에서 자바 버전을 11로 변경
4. web.xml에서 인코딩 필터 추가(한글 처리)
```xml
<filter>
	<filter-name>encodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter
	</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
	<init-param>
		<param-name>forceEncoding</param-name>
		<param-value>true</param-value>
	</init-param>
</filter>
<filter-mapping>
	<filter-name>encodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

## lombok
어노테이션을 사용해서 생성자, Getter & Setter, toString 작업을 간단하게 만들어줌

### pom.xml 설정
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
```

### 사용 예시
```java

```