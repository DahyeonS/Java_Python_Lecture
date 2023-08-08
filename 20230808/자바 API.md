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
str.charAt(6); // 6번 인덱스의 문자
```
#### 문자열값 비교
```java
str.equals("Hello My Name is Hong Gil Dong");
```
#### 특정 문자열의 위치(인덱스) 호출
```java
str.indexOf("Hong"); // "Hong" 문자열의 위치(없으면 -1)
```
#### 특정 인덱스부터 문자열 호출
```java
str.substring(17); // 17번 인덱스부터 문자열
```
#### 특정 구간만 문자열 호출
```java
str.substring(6, 13); // 6번부터 13번 인덱스까지 문자열
```
#### 소문자로 변경
```java
str.toLowerCase();
```
#### 대문자로 변경
```java
str.toUpperCase();
```
#### 문자열 길이 호출
```java
str.length();
```
#### 특정 문자열로 시작하는지 여부
```java
str.startsWith("Hello"); // 문자열이 "Hello"부터 시작하는가?
```
#### 특정 문자열로 끝나는지 여부
```java
str.endsWith("Dong"); // 문자열이 "Dong"으로 끝나는가?
```
#### 문자열 변경 - replace()
```java
str.replace("Hong", "Kim"); // "Hong"을 "Kim"으로 변경
```
#### 문자열 변경 - replaceAll()
정규표현식 사용 가능

*정규표현식 예시) [a-z], [A-z], [0-9], [a-zA-z0-9]*
```java
str.replaceAll("Name", "Nickname"); // "Name"을 "Nickname"으로 변경
```
#### 문자열로 출력
```java
str.toString();
```
#### 앞뒤 공백 제거
```java	
str.trim();
```
#### 모든 공백 제거
```java
str.replace(" ", "");
```
#### 숫자를 문자열로 변환
```java		
String.valueOf(10); // int 10을 문자열로 변환
String.valueOf(10.5); // double 10.5를 문자열로 변환
```
#### 특정 구간을 기준으로 문자열 분리
분리된 문자열은 배열로 저장
```java
str.split(","); // 컴마(,)를 기준으로 문자열 분리
```
#### 문자열을 숫자로 변환
```java
Integer.parseInt(str);
```
#### StringBuffer
기존 인스턴스를 유지한 채로 값을 추가할 수 있음

append() 사용

*String을 이용한 연산보다 소요시간이 크게 단축됨*
```java
StringBuffer sb1 = new StringBuffer("abcd");
sb1.append("efg");
```
### Math class
#### 절대값
```java
 Math.abs(-10); // 10
```
#### 올림
```java
Math.ceil(5.4); // 6.0
```
#### 내림
```java
Math.floor(5.4); // 5.0
```
#### 최대값
```java
Math.max(5, 4); // 5
```
#### 최소값
```java
 Math.min(5, 4); // 4
```
#### 0 ~ 1 사이 소수
```java
Math.random();
```
#### 짝수는 버림
```java
Math.rint(4.5); // 4.0
```
#### 홀수는 올림
```java
Math.rint(5.5); // 6.0
```
#### 반올림
```java
Math.round(4.5); // 5
```
### Wrapper class
구버전에서의 주요 클래스

최신 버전에서는 자동 형변환이 가능해지면서 중요성이 떨어짐
```java
Integer.MAX_VALUE; // int의 최대값 - 2147483647
Long.MAX_VALUE; // long의 최대값 - 9223372036854775807
Float.MAX_VALUE; // float의 최대값 - 3.4028235E38
Double.MAX_VALUE; // double의 최대값 -  1.7976931348623157E308
Double.SIZE; // double의 크기 - 64비트
```
### Random class
다양한 자료형의 랜덤한 숫자 호출

seed를 설정하여 난수 고정 가능(값이 고정됨)\
```java
Random r1 = new Random();
Random r2 = new Random(42); // seed - 42

r1.nextInt(); // 무작위 정수
r1.nextInt(5); // 0 ~ 5 사이의 정수
r1.nextInt(6) + 1; // 1 ~ 7 사이의 정수
r1.nextBoolean(); // true, false 중에 랜덤
r.nextGaussian(); // 정규분포 범위 안에서 랜덤한 실수
```
