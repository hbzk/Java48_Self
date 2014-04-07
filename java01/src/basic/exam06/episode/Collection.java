package basic.exam06.episode;

//  객체 주소들을 보관
public class Collection {
	Object[] list;
	int cursor;
	
	public Collection() {
		list = new Object[1000];
	}
	
	public Collection(int initSize) {
		list = new Object[initSize];
	}
	
	public void add(Object obj) throws Exception { 	// > throws 여러개 올 수 있으므로 복수형 
		if (cursor < list.length) {
			list[cursor++] = obj;
			// return 0; // 리턴값으로 정상 상황 보고
			
		}	else {
			// 예외를 보고하는 전문적인 문법이 필요!
			throw new Exception("인덱스가 배열 크기를 초과했다!");
			
			// System.out.println("꽉 찼습니다."); 	// 명령창에 출력하여 예외 보고
			// return -1; // 리턴값으로 예외 상황 보고
		}
	}
	
	public Object get(int index) throws Exception {
		if (index >=0 && index < list.length) {
			return list[index];
		}	else {
			throw new Exception("인덱스가 옳지 않습니다.");
		}
	}
	
	public int size() {
		return cursor; 	// > ++이 된 상태이므로 갯수로 활용 가능
	}
}

