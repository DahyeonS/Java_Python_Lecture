package bankpkg;

public class SingleTonBankMain {

	public static void main(String[] args) {
		SingleTonBank stb1 = SingleTonBank.getInstance();
		SingleTonBank stb2 = SingleTonBank.getInstance();
		SingleTonBank stb3 = SingleTonBank.getInstance();
		System.out.println(stb1);
		System.out.println(stb2);
		System.out.println(stb3);
	}
	
}
