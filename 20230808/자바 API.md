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
```java
String[] arr = {"홍길동", "이순신", "김유신", "안중근"}; // // ["홍길동", "이순신", "김유신", "안중근"]
String[] arr2 = arr.clone(); // ["홍길동", "이순신", "김유신", "안중근"]

System.out.println(arr == arr2); // 주소가 다름(false)
System.out.println(arr.equals(arr2)); // false
```
