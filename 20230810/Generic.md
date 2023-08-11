# Generic
데이터 타입(자료형)을 미리 강제함

사용 시 형변환 필요 없음
```java
Generic<String> gen = new Generic<String>(); // 문자열만 사용 가능
Generic<Integer> gen2 = new Generic<Integer>(); // 정수만 사용 가능
List<Member> list = new ArrayList<>(); // Member 자료형만 사용 가능
```
