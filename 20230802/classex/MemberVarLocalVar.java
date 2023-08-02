package classex;

public class MemberVarLocalVar {
	
	int memInt;
	String memString;
	
	static void go() {
		
	}

	public static void main(String[] args) {
		int localInt = 0;
		String localString = "";
		
		System.out.println(localInt);
		MemberVarLocalVar mvlv = new MemberVarLocalVar();
		System.out.println(mvlv.memInt);
	}

}
