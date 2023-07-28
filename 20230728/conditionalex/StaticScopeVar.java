package conditionalex;

public class StaticScopeVar {
	
	static int j = 10;
	public static void main(String[] args) {
		int i = 1;
		System.out.println(j); // 10
		{
			StaticScopeVar.j = 100;
			int inner = i + j;
			System.out.println(inner); // 101
		}
		int outer = i + j;
		System.out.println(outer); // 101
	}

}
