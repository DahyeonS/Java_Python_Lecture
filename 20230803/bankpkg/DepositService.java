package bankpkg;

public class DepositService {
	private void open() {
		System.out.println("입금 작업 시작");
	}
	
	private void deposit() {
		System.out.println("입금 작업");
	}
	
	private void close() {
		System.out.println("입금 작업 완료");
	}
	
	void work() {
		open();
		deposit();
		close();
	}
}
