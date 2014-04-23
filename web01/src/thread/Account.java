package thread;

public class Account {
	long balance;
	
	public Account(int money) {
		this.balance = money;
	}
	
	// * 스레드 안전(Thread Safe)
	// - 스레드가 동시에 접근해도 상관 없는 메서드의 예시
	// - synchronized가 필요 없다. 
	public long getBalance() {
		return this.balance;
	}
	
	/* Critical Section
	 * - 동시에 여러 스레드가 실행돼서는 안되는 구간(명령어 블럭)
	 * - 변수에 동시에 접근해서 사용할 때 문제 발생
	 * - 해결책 : 동시에 접근하지 못하게 만든다.
	 * 
	 * synchronized
	 * - 하나의 스레드가 크리티컬 섹션에 접근하면 즉시 잠근다. (locking)
	 *  	> 뮤텍스 : 한 번에 하나의 스레드만 진입 허용  
	 *  	> 세마포어 : 지정된 개수 만큼 진입 허용 (자바에서는 자동 구현 불)
	 */
	
  synchronized public void withdraw(int money) throws Exception {
		long currMoney = this.balance;
		
		currMoney = currMoney - money;
		
		// 지연을 위해 강제로 복잡한 연산 삽입
		for (int i = 0; i < 1000; i++) {
			int sleepTime = (int) (Math.random() * 600 * 345.12345 * i);
			sleepTime = (int) (Math.random() * 100 * 345.12345 * i);
			sleepTime = (int) (Math.random() * 200 * 345.12345 * i);
			sleepTime = (int) (Math.random() * 300 * 345.12345 * i);
			sleepTime = (int) (Math.random() * 400 * 345.12345 * i);
			sleepTime = (int) (Math.random() * 500 * 345.12345 * i);
    }
		//Thread.currentThread().sleep(sleepTime);
		
		if (currMoney >= 0) {
			this.balance = currMoney;
		}	else {
			throw new Exception("잔액부족!");
		}
	}
}
