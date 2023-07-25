# IDE 없이 Java 실행하는 방법

1. 명령 프롬프트로 Java 파일을 저장하고자 하는 위치로 이동 후, 편집기를 실행한다.

```
cd 디렉토리명
notepad++
```

2. 편집기에 다음과 같은 문장을 입력한 후, 파일명을 *Hello.java*로 하여 저장한다.
```java
public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello World!!");
	}
}
```

3. 명령 프롬프트로 다음과 같은 문장을 입력하여 실행한다.
```
cd 디렉토리명
javac Hello.java
(dir)
java Hello
```

4. 아랫줄에 다음과 같은 문구가 출력되면 성공
```
Hello World!!
```
