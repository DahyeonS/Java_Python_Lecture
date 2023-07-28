package conditionalex;

public class LocalScopeVar {

	public static void main(String[] args) {
		int i = 1;
		{
			int j = 0;
			int inner = i + j;
		}
		
//		int outer = i + j; // j가 블록 밖에 있기 때문에 오류
	}

}
