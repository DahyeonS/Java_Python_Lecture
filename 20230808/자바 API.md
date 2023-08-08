# 자바 API

**자바 JDK에서 기본으로 제공하는 API**

## java.lang
임포트 없이 사용

### Object class
모든 클래스들의 조상(부모)이 되는 최상위 클래스

*11개의 메서드를 갖고 있음*
```java
public class Animal extends Object {

}
```
### equals()
주소 체크

값 체크 시 재정의 필요

String의 경우 이미 재정의 되어있음
```java
// Object
Object o1 = new Object();
Object o2 = new Object();

System.out.println(o1.equals(o2)); // false

// String
String s1 = "abcd";
String s2 = "abcd";

System.out.println(s1.equals(s2)); // true
```
### toString()
문자열로 표현
```java
// 클래스
@Override
public String toString() {
  return name + " / " + color;
}

System.out.println(f.toString());

// 배열
int arr[] = {1, 2, 3, 4};
System.out.println(Arrays.toString(arr));
```
### clone()
대상을 복사
```java
String[] arr = {"홍길동", "이순신", "김유신", "안중근"}; // // ["홍길동", "이순신", "김유신", "안중근"]
String[] arr2 = arr.clone(); // ["홍길동", "이순신", "김유신", "안중근"]

System.out.println(arr == arr2); // 주소가 다름(false)
System.out.println(arr.equals(arr2)); // false
```
### System class
시스템 정보를 불러오는 클래스
```java
System.out.println(System.getProperty("java.version"));
System.out.println(System.getProperty("java.home"));
System.out.println(System.getProperty("os.name"));
System.out.println(System.getProperty("file.separator"));
System.out.println(System.getProperty("user.name"));
System.out.println(System.getProperty("user.home"));
		
for (String key : System.getenv().keySet()) {
  System.out.println(key + ": " + System.getenv(key));
}
```
### Class class
클래스의 정보를 불러오는 클래스
```java
EnvEx env = new EnvEx();
Class c1 = env.getClass();
System.out.println(c1.getName());
System.out.println(c1.getPackageName());
```
### String class
#### 문자열 주소 호출
```java
System.identityHashCode(str);
```
#### *특정 인덱스의 문자열 호출*
```java
System.out.println(str.charAt(6)); // 6번 인덱스의 문자
```
#### 문자열값 비교
```java
System.out.println(str.equals("Hello My Name is Hong Gil Dong"));
```
#### 특정 문자열의 위치(인덱스) 호출
```java
System.out.println(str.indexOf("Hong")); // "Hong" 문자열의 위치(없으면 -1)
```
```java
System.out.println(str.substring(17)); // 17번 인덱스까지 문자열 앞부분 삭제 - Hong Gil Dong
System.out.println(str.substring(6, 13)); // 6번부터 13번 인덱스까지 문자열 출력 - My Name
System.out.println(str.toLowerCase()); // 문자열 소문자로 변경 - hello my name is hong gil dong
System.out.println(str.toUpperCase()); // 문자열 대문자로 변경 - HELLO MY NAME IS HONG GIL DONG
System.out.println(str.length()); // 문자열 길이 - 30
System.out.println(str.startsWith("Hello")); // 문자열이 "Hello"부터 시작하는지 여부 - true
System.out.println(str.endsWith("Dong")); // 문자열이 "Dong"으로 끝나는지 여부 - true
System.out.println(str.replace("Hong", "Kim")); // "Hong"을 "Kim"으로 변경 - Hello My Name is Kim Gil Dong
System.out.println(str.replaceAll("Name", "Nickname")); // "Name"을 "Nickname"으로 변경(replaceAll은 정규표현식 사용 가능 ex.[a-zA-z0-9]) - Hello My Nickname is Hong Gil Dong
System.out.println(str.toString()); // 문자열로 출력 - Hello My Name is Hong Gil Dong
		
str = "   안녕 하세요,     반갑습니다.      ";
System.out.println(str.trim()); // 앞뒤 공백 제거 - 안녕 하세요,     반갑습니다.
System.out.println(str.replace(" ", "")); // 모든 공백 제거 - 안녕하세요,반갑습니다.
		
str = String.valueOf(10); // int 10을 문자열로 변환
str = String.valueOf(10.5); // double 10.5를 문자열로 변환
		
str = "홍길동,이순신,유관순,안중근";
String[] arr = str.split(",");
for (int i=0; i<arr.length; i++) {
	System.out.println(i + "번 인덱스 값 = " + arr[i]);
}
```
