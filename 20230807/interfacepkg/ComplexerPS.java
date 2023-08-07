package interfacepkg;

public class ComplexerPS implements Printer, Scanner {

	@Override
	public void scan() {
		System.out.println("scan!!");
	}

	@Override
	public void print() {
		System.out.println("print!!");
	}
	
}
