package thread;

public class ATM extends Thread {
	String flag;
	String title;
	Account account;
	long sum;
	public ATM(Account account, String title, String flag) {
		this.flag = flag;
		this.account = account;
		this.title = title;
	}
	
	@Override
	public void run() {

		try {
			for (int i = 0; i < 100; i++) {
				account.withdraw(100000);
				sum += 100000;
				System.out.println(flag + i);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n[" + title + "]찾은 금액: " + sum + "원");
	}
}
