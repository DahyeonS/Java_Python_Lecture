package abstractpkg;

public class FinalClassMain {
	public static void main(String[] args) {
		FinalClass fc = new FinalClass();
		fc.abMethod1();
		fc.abMethod2();
		fc.finalMethod();
		
		AbsClass2 ac2 = new FinalClass();
		ac2.abMethod1();
		ac2.abMethod2();
		
		AbsClass1 ac1 = new FinalClass();
		ac1.abMethod1();
		
		FinalClass fc2 = (FinalClass)ac1;
		fc.abMethod1();
		fc2.abMethod1();
		fc.finalMethod();
	}

}
