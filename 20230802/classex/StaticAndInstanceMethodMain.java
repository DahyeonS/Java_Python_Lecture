package classex;

public class StaticAndInstanceMethodMain {
	
	public static void main(String[] args) {
		System.out.println(StaticAndInstanceMethod.sVar);
		StaticAndInstanceMethod.staticCall();
		StaticAndInstanceMethod saim = new StaticAndInstanceMethod();
		System.out.println(saim.iVar);
		saim.instantCall();
	}

}
