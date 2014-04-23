package thread;

public class ATMTest implements Runnable {
	Account 계좌 = new Account(10000000);
	ATM 강남 = new ATM(계좌, "강남", "강");
	ATM 수원 = new ATM(계좌, "수원", "수");
	ATM 부산 = new ATM(계좌, "부산", "부");
	ATM 광주 = new ATM(계좌, "광주", "광");
	ATM 세종 = new ATM(계좌, "세종", "세");
	
	@Override
	public void run() {
	  while (true) {
	  	if (!강남.isAlive() && 
	  			!수원.isAlive() && 
	  			!부산.isAlive() && 
	  			!광주.isAlive() && 
	  			!세종.isAlive()) {
	  		break;
	  	}
	  }
	  System.out.println("총 찾은 금액: " + (강남.sum + 수원.sum + 부산.sum + 광주.sum + 세종.sum));
	}
	
	
	public void test() {
		강남.start();
		수원.start();
		부산.start();
		광주.start();
		세종.start();
		
		Thread 모니터 = new Thread(this);
		모니터.start();
	}
	
	public static void main(String[] args) {
		ATMTest t = new ATMTest();
		t.test();
	}
}
