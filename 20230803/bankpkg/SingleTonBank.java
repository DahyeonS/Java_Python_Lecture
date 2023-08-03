package bankpkg;

public class SingleTonBank {
	private static SingleTonBank instance = new SingleTonBank();
	
	private SingleTonBank() {
		
	}
	
	static SingleTonBank getInstance() {
		return instance;
	}
}
