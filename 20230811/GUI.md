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
>
> 창 크기에 따라 버튼의 위치가 달라짐
> ```java
> void flowLayout() {
> 	p1.setLayout(new FlowLayout());
> 	p1.add(button1);
> 	p1.add(button2);
> 	p1.add(button3);
> 	p1.add(button4);
> 	p1.add(button5);
> }
> ```
> #### GridLayout
> 가로×세로 격자 모양 배치
> #### BorderLayout
> 가운데 컴포넌트 중심으로 네 방향으로 배치
>
> 설정한 위치(동-서-남-북-중앙)로 버튼이 할당
> ```java
> void borderLayout() {
> 	p1.setLayout(new BorderLayout());
> 	p1.add(button1, BorderLayout.NORTH);
> 	p1.add(button2, BorderLayout.WEST);
> 	p1.add(button3, BorderLayout.EAST);
> 	p1.add(button4, BorderLayout.SOUTH);
> 	p1.add(button5, BorderLayout.CENTER);
> }
> ```
> #### CardLayout
> 탭 등으로 여러 개의 레이아웃들 중 하나만 보여줌
>
> 특정 버튼을 누르면 레이아웃 이동
> ```java
> void cardLayout() {
> 	final CardLayout CARD = new CardLayout();
> 	setLayout(CARD);
> 	p1.add(button1);
> 	p1.add(button2);
> 	p1.add(button3);
> 	p2.add(button4);
> 	p2.add(button5);
> 	add("p1", p1);
> 	add("p2", p2);
>
> 	button3.addActionListener(new ActionListener() {
> 		@Override
> 		public void actionPerformed(ActionEvent e) {
> 			CARD.show(getContentPane(), "p2");
> 		}
> 	}); // 버튼3을 누르면 레이아웃 이동
>
> 	button5.addActionListener(new ActionListener() {
> 		@Override
> 		public void actionPerformed(ActionEvent e) {
> 			CARD.show(getContentPane(), "p1");
> 		}
> 	}); // 버튼 5를 누르면 레아아웃 이동
> }
> ```
> ```java
> // 적용
> public SwingLayout() {
> 	super("Layout Showcase");
> 	getContentPane().add(p1);
> 	cardLayout();
> 	setDefaultCloseOperation(EXIT_ON_CLOSE);
> 	setSize(300, 200);
> 	setVisible(true);
> }
> ```
### 이벤트 핸들링
GUI 프로그램에서 발생하는 의미 있는 신호

- ActionEvent - 컴포넌트에 정의된 행위가 발생할 때
- MouseEvent - 마우스 액션이 발생할 때
- KeyEvent - 컴포넌트 안에서 키 입력이 발생할 때
- ComponentEvent - 컴포넌트 이동이나 크기 변경 등이 발생할 때
- ContainEvent - 컴포넌트 추가나 삭제 등이 발생 할 때
```java
// 메서드 생성
@Override
public void actionPerformed(ActionEvent e) {
	Object obj = e.getSource();

	if(obj == button1) index--;
	else if(obj == button2) index++;

	if(index > 2) index = 0;
	else if(index < 0) index = 2;

        button3.setText(msgs[index]);
}

// 적용
button1.addActionListener(this);
button2.addActionListener(this);
```
