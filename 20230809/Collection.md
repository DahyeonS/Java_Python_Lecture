# Collection

## Collection 인터페이스
### List
저장 순서 유지, 중복 저장 가능

*종류) ArrayList, Vector, LinkedList*
```java
List list = new ArrayList();

list.add(1); // 리스트 값 추가
list.get(i); // 인덱스의 i번째 값 호출
```
#### Vector
구버전에서 사용
```java
Vector list = new Vector();

list.addElement(3.4); // 값 추가
list.contains(num); // 값의 유무 호출(없으면 -1, boolean으로도 호출 가능)
```
#### ArrayList
읽기에서 주로 사용

[참고](20230802/ArrayList.md)
- LinkedList - 데이터를 추가, 삭제 작업을 주로 하는 경우에 사용
### Set

## Map 인터페이스
