package basic.exam05.step06;

import java.util.EventObject;

/* 개념
 * 1) 기본 생성자: 개발자가 만들지 않으면 컴파일러가 만들어준다.
 * 2) 생성자에서 super 클래스의 생성자를 지정하지 않으면, super의 기본 생성자 호출
 * 3) java.io.serializable 구현 클래스는 가급적 데이터 버전 정보를 가져야 한다.
 *  		- 부모 클래스가 구현하면 자식 클래스는 자동으로 적용된다.
 * 4) Overloading : 같은 기능을 하는 메서드에 대해 같은 이름 부여 =>
 *  													- 프로그래밍의 일관성 부여.
 * 5) 상속 : 수퍼 클래스의 속성과 메서드를 물려받는다.
 */

public class StateChangeEvent extends EventObject {
  private static final long serialVersionUID = 1L; 	// > Serializable
  
  public String stateName;
  
	public StateChangeEvent(Object source) {
	  super(source);
  }

	public StateChangeEvent(Object source, String stateName) {
	  super(source);
	  this.stateName = stateName;
  }
	
}
