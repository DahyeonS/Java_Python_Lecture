package bankpkg;

public class Account2 {
	private String name;
	private int balance;
	
	public Account2() {
		
	}

	public Account2(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account2 [name=" + name + ", balance=" + balance + "]";
	}
}
