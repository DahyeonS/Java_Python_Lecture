package abstractpkg;

public class FinalClass extends AbsClass2 {

	@Override
	void abMethod2() {
		System.out.println("final: abMethod2");
	}

	@Override
	void abMethod1() {
		System.out.println("final: abMethod1");
	}
	
	void finalMethod() {
		System.out.println("final: finalMethod");
	}

}
