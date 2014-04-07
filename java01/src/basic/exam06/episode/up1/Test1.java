package basic.exam06.episode.up1;

public class Test1 {
	static SuCollection coll; 	// > 상위 클래스의 변수로 생성시, 어떤 자손의 주소라도 담을 수 있다. 
	
	public static void testAdd() {
		coll.add("홍길동");
		coll.add("임꺽정");
		coll.add("장보고");
		coll.insert(2, "장길산");
	}
	
	public static void testList() {
		for (int i = 0; i < coll.size(); i++) {
			System.out.println(coll.get(i));			
		}
	}
	
	public static void main(String[] args) {
		coll = new Collection3();
		
		try {
			testAdd();
		}	catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			testList();
		}	catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		coll.size();
		// System.out.println("get(1) : " + coll.get(1));
	}
}
