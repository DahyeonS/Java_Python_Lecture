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
#### [ArrayList](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230802/ArrayList.md)
읽기에서 주로 사용

index 기반으로 연속적인 데이터가 존재

##### *LinkedList*
데이터를 추가, 삭제 작업을 주로 하는 경우에 사용

데이터끼리 서로 연결된 형태
### Set
수학의 집합과 같음

**순서가 유지되지 않고 중복 불가능**
```java
Set lotto = new HashSet(); // 순서 정렬 X
Set lotto2 = new TreeSet(); // 순서 정렬
```
#### Iterator
![Iterator1](http://www.taeyo.net/lecture/8_Board_taezi/lecture_03/images/03_07.gif)
![Iterator2](http://www.taeyo.net/lecture/8_Board_taezi/lecture_03/images/03_08.gif)

파일 시스템/데이터베이스에 저장되어 있는 객체를 호출하는 개념
```java
Iterator it = null;
it = list.iterator(); // 벡터나 리스트 등을 변환 필요

it.hasNext(); // 다음 포인터(커서에) 데이터가 존재하면 true, 존재하지 않으면 false
it.hasPrevious(); // 이전 포인터(커서에) 데이터가 존재하면 true, 존재하지 않으면 false
it.next(); // hasNext()가 true면 데이터 호출
it.previous(); // hasPrevious()가 true면 데이터 호출
```
##### Enumeration
Iterator의 구버전
```java
Enumeration e = v.elements(); // 벡터를 변환

et.hasMoreElements(); // Iterator의 hasNext()와 동일한 기능
e.nextElement(); // Iterator의 next()와 동일한 기능
```
##### ListIterator

## Map 인터페이스
