package interfacepkg;

public class ComplexMain {

	public static void main(String[] args) {
		ComplexerPS cps = new ComplexerPS();
		cps.print();
		cps.scan();
		
		ComplexPSF cpsf = new ComplexPSF();
		cpsf.print();
		cpsf.scan();
		cpsf.send("02-2222-3333");
		cpsf.receive("02-3333-4444");
	}

}
