package interfacepkg;

public class ComplexPSF implements Printer, Scanner, Fax {

	@Override
	public void send(String tel) {
		System.out.println(FAX_NUMBER + " => " + tel);
	}

	@Override
	public void receive(String tel) {
		System.out.println(FAX_NUMBER + " <= " + tel);
	}

	@Override
	public void scan() {
		System.out.println("scan!!");
	}

	@Override
	public void print() {
		System.out.println("print!!");
	}

}
