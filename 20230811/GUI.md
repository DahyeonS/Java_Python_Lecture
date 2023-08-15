# GUI
그래픽 유저 인터페이스

타이틀바, 메뉴, 버튼, 스크롤바 등으로 조작

- 레이아웃 객체로 레이아웃을 정의
- 컴포넌트를 생성해 레이아웃을 배치
- 이벤트 핸들러를 등록
- 발생한 이벤트를 처리
## AWT
Abostract Window Toolkit

자바의 기본적인 윈도우 툴킷

최소한의 기능만 정의되어 있음
```java
Frame f = new Frame("Hello Wordl!!"); // "Hello Wordl!!"라는 이름의 프레임 생성
f.setLayout(new FlowLayout()); // 레이아웃 적용
Label label = new Label("Welcome to AWT"); // "Welcome to AWT" 문자열을 레이블로 생성
f.add(label); // 해당 레이블을 프레임 안에 출력
f.setSize(500, 500); // 프레임 사이즈 설정
f.setVisible(true); // 화면에 구현
f.addWindowListener(new WindowCloseHandler()); // 창닫기 실행
```
### 창닫기 메서드
따로 생성해서 적용하지 않으면 해당 명령을 수행 불가
```java
class WindowCloseHandler extends WindowAdapter {
  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);
	}
}
```
## Swing
좀 더 다양한 컴포넌트 등을 추가한 새로운 툴킷
```java
// 메서드 생성
public SwingEx() {
	super("Hello World"); // 프레임(창) 이름 설정
	getContentPane().setLayout(new FlowLayout()); // 레이아웃 적용
	JLabel label = new JLabel("Welcome to Swing!!"); // "Welcome to Swing" 문자열을 레이블로 생성
	getContentPane().add(label); // 해당 레이블을 프레임 안에 출력
	setDefaultCloseOperation(EXIT_ON_CLOSE); // 창닫기 실행
	setSize(500, 500); // 프레임 사이즈 설정
	setVisible(true); // 화면에 구현
}

// 해당 메서드를 메인 메서드에 적용
SwingEx app = new SwingEx();
```
> ### *레이아웃*
> #### FlowLayout
> *기본 레이아웃*
>
> 가로로 배치
>
> 길이가 부족하면 다음 줄에 배치
> ```java
> void flowLayout() {
> 	p1.setLayout(new FlowLayout());
> 	p1.add(button1);
> 	p1.add(button2);
> 	p1.add(button3);
> 	p1.add(button4);
>	p1.add(button5);
> }
> ```
> #### GridLayout
>
> ```java
> ```
> #### BorderLayout
>
> ```java
> ```
> #### CardLayout
>
> ```java
> ```
