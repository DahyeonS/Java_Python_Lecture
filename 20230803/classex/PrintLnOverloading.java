package classex;

public class PrintLnOverloading {
	public static void main(String[] args) {
		System.out.println(1); // int
		System.out.println("a"); // String
		System.out.println('c'); // char
		System.out.println(true); // boolean
		
//		오버로딩이 지원되지 않은면 어떤 문제가 생길까요? => 파이썬 등은 지원하지 않음
		/*
		System.out.printlnInt(1); // int
		System.out.printString("a"); // String
		System.out.printChar('c'); // char
		System.out.printBoolean(true); // boolean
		*/
	}
}
