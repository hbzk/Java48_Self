package basic.exam06.episode;


// > LinkedList<E> 직접 구현 
public class Collection3 {
	class Box {
		Object value;
		Box next;
	}
	
	int length; 	// > 갯수
	
	Box start;	 		// > 시작 상자
	Box end; 			// > 끝 상자
	
	public Collection3() {
		start = new Box();
		end = start; 	// > Box의 주소를 담고 있다.
	}
	
	public void add(Object obj) {
		end.value = obj; 		// > end Box의 value에 obj를 넣는다.
		end.next = new Box(); 		// > 박스를 새로 만들고 next로 주소를 연결한다.
		end = end.next; 		// > 새로 만든 Box를 end의 주소로 지정(마지막 Box)한다.
		length++;
	}
	
	public Object get(int index) {
		if (index >= 0 && index < length) {
			Box cursor = start;
			int pos = 0;
			do {
				if (index == pos) {
					return cursor.value;
				}	else {
					cursor = cursor.next;
				}
				pos++;
			}	while (cursor != null); 	// > if (cursor.next == null) {	break;}
			return cursor.value;
		}	else {
			throw new RuntimeException("유효하지 않은 인덱스입니다.");
		}
	}
	
	public int size() {
		return length; 	// > ++ 된 상태이므로 갯수로 활용 가능
	}
	
	public void insert(int index, Object value) {
		if (index >= 0 && index < length) {
			
		}
	}
}

