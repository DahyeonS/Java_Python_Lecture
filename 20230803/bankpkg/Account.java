package bankpkg;

class Account {
	private String name;
	private int balance;
	
//	get
	String getName() {
		return this.name;
	}
	
	int getBalance() {
		return this.balance;
	}
	
//	set
	void setName(String name) {
		if (name == null | name.isEmpty()) {
			System.out.println("name을 넣어주세요.");
			return;
		}
		this.name = name;
	}
	
	void setBalance(int balance) {
		if (balance < 0) {
			System.out.println("balance는 0보다 커야합니다.");
			return;
		}
		this.balance = balance;
	}
}
