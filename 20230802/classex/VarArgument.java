package classex;

public class VarArgument {
	void printInfo(String...infos) {
		if (infos.length != 0) {
			for (int i=0; i<infos.length; i++) {
				System.out.print(infos[i] + " ");
			}
			System.out.println();
		}
	}
	
	void printInfo2(String[] infos) {
		if (infos.length != 0) {
			for (int i=0; i<infos.length; i++) {
				System.out.print(infos[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		VarArgument va = new VarArgument();
		va.printInfo();
		va.printInfo("aaa");
		va.printInfo("aaa", "bbb", "ccc");
		
		String[] s = {"aaa", "bbb", "ccc"};
		va.printInfo2(s);
	}

}
