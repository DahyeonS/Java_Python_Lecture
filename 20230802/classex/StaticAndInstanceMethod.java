package classex;

public class StaticAndInstanceMethod {
	
	static int sVar;
	int iVar;
	
	static void staticCall() {
		System.out.println("staticCall()");
		System.out.println("sVar = " + sVar);
//		System.out.println("iVar = " + iVar);
	}
	
	void instantCall() {
		System.out.println("instantCall()");
		System.out.println("sVar = " + sVar);
		System.out.println("iVar = " + iVar);
	}

}
