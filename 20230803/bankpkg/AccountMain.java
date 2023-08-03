package bankpkg;

public class AccountMain {

	public static void main(String[] args) {/*
		Account account = new Account();
//		account.setName("");
		account.setName("hong");
//		account.setBalance(-10000);
		account.setBalance(10000);
		System.out.println(name);
		System.out.println(balance);
		*/
		Account2 account = new Account2();
		account.setName("hong");
		account.setBalance(10000);
		System.out.println(account.toString());
		
		String name = account.getName();
		int balance = account.getBalance();
		
		DepositService depositService = new DepositService();
		depositService.work();
	}

}
