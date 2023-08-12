# File I/O
**스트림** - 데이터 입/출력 시 매개체 역할

파일이 없는 경우를 대비해 *try/catch*문을 주로 사용함
## 바이트 기반 입출력
바이트 단위로 데이터를 처리

한글은 인식 불가능
#### InputStraem
System.in의 in은 InputStream을 구현한 객체
```java
System.in.read(); // 데이터를 1byte씩 아스키 코드에 해당하는 정수 형태로 읽어옴(문자로 출력하려면 형변환 필요)
```
#### FileInputStream
파일에서 데이터를 바이트 단위로 읽어옴
```java
FileInputStream fIn = new FileInputStream(path); // path는 읽어올 파일 경로
fIn.read(); // 데이터를 정수로 읽어옴(문자로 출력하려면 형변환 필요)
```
#### ByteArrayInputStream
배열을 바이트 단위로 읽어옴
```java
ByteArrayInputStream bai = new ByteArrayInputStream(data); // data는 읽어올 배열
bai.read(); // 위 사례들과 동일
```
## 문자 기반 입출력

## 객체 입출력
