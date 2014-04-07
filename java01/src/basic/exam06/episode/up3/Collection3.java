package basic.exam06.episode.up3;

public class Collection3 extends AbstractCollection {
	class Box {
		Object value;
		Box next;
	}
	
	Box start;	 		// > 시작 상자 (주소 저장용)
	Box end; 			// > 끝 상자 (주소 저장용)
	
	public Collection3() {
		start = new Box();
		end = start; 	// > Box의 주소를 담고 있다.
	}
	
	@Override
	public void add(Object obj) {
		end.value = obj; 		// > end Box의 value에 obj를 넣는다.
		end.next = new Box(); 		// > 박스를 새로 만들고 next로 주소를 연결한다.
		end = end.next; 		// > 새로 만든 Box를 end의 주소로 지정(마지막 Box)한다.
		length++;
	}
	
	@Override
	public Object get(int index) {
		if (index >= 0 && index < length) {
			Box cursor = start;
			for (int pos = 0; pos < index; pos++) {
				cursor = cursor.next;
			}
			return cursor.value;
		} else {
			throw new RuntimeException("무효한 인덱스입니다.");
		}
	}
	
	@Override
	public void insert(int index, Object value) {
		if (index == 0) {
			Box next = start;
			start = new Box();
			start.value = value;
			start.next = next;
			
		} else if (index > 0 && index < length) { 	// > 인덱스 유효성 검증
			Box cursor = start; 																			// > cursor를 첫 박스에 위치
			for(int pos = 1; pos < index; pos++) { 		// > 1부터 > insert할 인덱스 보다 작을동안 > 반복
				cursor = cursor.next; 																// > 다음값으로 커서를 이동
			} 	 																																// > ==> cursor를, "insert할 위치 바로 전" 까지 이동 시키는 for 문 완료
			
			Box temp = new Box(); 															// > 삽입 할 새 박스 생성
			temp.value = value; 																	// > 새 박스에 삽입 할 값(주소) 넣고
			
			temp.next = cursor.next;														// > cursor(insert할 위치 바로 전)의 next를, 새 박스 next 주소로 연결
																																					//==> 새 박스 'next' 주소 연결
			cursor.next = temp; 																		// > (insert할 위치 바로 전)의 next를 새 박스로 연결		
																																					//==> 새 박스 '이전' 주소 연결
			
		} else {
			throw new RuntimeException("인덱스가 무효합니다.");
		}
		length++;
	}
}

