package basic.exam06.episode.up3;

/* 추상 클래스
 * - 추상 메서드를 하나라도 포함하고 있는 클래스
 */
public abstract class AbstractCollection {
	int length;
	
	// 하위 클래스가 재정의 해야할 매서드는 반드시 재정의 하도록 강제함 => abstract 메서드
	// 어차피 하위 클래스에서 재정의 할 메서드라면 추상 메서드로 선언한다.
	public abstract void add(Object value);
	public abstract void insert(int index, Object value);
	public abstract Object get(int index);
	
	public int size() {
		return length;
  }
}

