# File I/O
**스트림** - 데이터 입/출력 시 매개체 역할

파일이 없는 경우를 대비해 *try/catch*문을 주로 사용함
## 바이트 기반 입출력
바이트 단위로 데이터를 처리

한글은 인식 불가능
### InputStraem
System.in의 in은 InputStream을 구현한 객체
```java
System.in.read(); // 데이터를 1byte씩 아스키 코드에 해당하는 정수 형태로 읽어옴(문자로 출력하려면 형변환 필요)
```
### FileInputStream
파일에서 데이터를 바이트 단위로 읽어옴

파일을 대상으로 작업을 할 땐 close()를 사용해서 스트림을 닫아야 함
```java
FileInputStream fIn = null;
fIn = new FileInputStream(path)// path는 읽어올 파일 경로
fIn.read(); // 데이터를 정수로 읽어옴(문자로 출력하려면 형변환 필요)
```
### ByteArrayInputStream
배열을 바이트 단위로 읽어옴
```java
ByteArrayInputStream bai = null;
bai = new ByteArrayInputStream(data); // data는 읽어올 배열
bai.read(); // 위 사례들과 동일
```
### OutputStream
바이트 기반 출력

지정된 디렉토리가 유효하지 않을 시 예외 발생
```java
os.write(byteMsg); // byteMsg의 내용을 출력
```
### FileOutputStream
```java
FileOutputStream fo = null;
fo = new FileOutputStream(path); // path 디렉토리에 파일 생성
```
### ByteArrayOutputStream
배열을 바이트 단위로 출력
```java
ByteArrayOutputStream bao = null;
bao = new ByteArrayOutputStream();
```
## 문자 기반 입출력
### Reader
문자 타입으로 데이터를 처리

**한글 인식 가능**
#### BufferedReader
```java
// byte로 뚫고
FileInputStream fi = null;
// reader로 변환
InputStreamReader isr = null;
// 한 줄씩 읽기 
BufferedReader bfr = null;

bfr.readLine(); // 한 줄씩 읽어서 String으로 변환
```
##### *StringTokenizer*
문자열을 특정 구분자로 나눔
```java
StringTokenizer st = null;
st = new StringTokenizer(address, ",")// ,를 기준으로 문자열을 나눔
```
#### FileReader
바이트 -> reader 변환없이 바로 문자 타입으로 읽음
```java
FileReader fr = null;
fr = new FileReader(path); // path는 읽어올 파일 경로
```
#### *InputStreamReader*
InputStraem의 Reader버전

데이터를 바이트가 아닌 문자 타입으로 읽어들임
```java
InputStreamReaderTest isrt = null;
isrt = new InputStreamReaderTest();
```
### Writer
데이터를 문자 단위로 출력
#### FileWriter
문자 단위의 데이터를 파일로 만듦
```java
FileWriter fw = null;
fw = new FileWriter(path); // path는 작성할 파일 경로
```
#### BufferedWriter
flush를 해야 데이터 출력, buffer 사이즈보다 데이터 출력이 많아지면 자동으로 flush

close()를 실행하면 자동으로 출력
```java
BufferedWriter bw = null;
bw = new BufferedWriter(fw, 4); // fileWriter로 호출한 객체를 실행
```
#### *OutputStreamWriter*
OutputStraem의 문자 버전
```java
OutputStreamWriter outWriter = null;
outWriter = new OutputStreamWriter(output);
```
## 객체 입출력
*직렬화* - 객체를 파일로 변환 후 연속되는 바이트로 네트워크에 출력

*역직렬화* - 직렬화된 바이트를 객체로 변환
### Serializable 인터페이스
메소드 없이 직렬화할 객체에 구현(구현없이 직렬화 시도 시 예외 발생)

*특정 변수를 직렬화 대상에서 제외할 시 transient 사용*

[참고](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230811/iopkg/SerializableUser.java)
#### ObjectOutputStream
객체를 출력할 때 직렬화
```java
ObjectOutputStream objectos = null;
objectos = new ObjectOutputStream(fileos); // FileOutputStream로 호출한 객체를 실행
objectos.writeObject(beforeUser); // beforeUser를 FileOutputStream으로 지정한 경로에 파일로 저장
```
#### ObjectInputStream
객체를 읽어올 때 역직렬화
```java
ObjectInputStream objectis = null;
objectis = new ObjectInputStream(fileis); // FileInputStream로 호출한 객체를 실행
objectis.readObject(); // 지정된 경로에 있는 파일을 역직렬화
```
