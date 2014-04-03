package basic.exam05.ex01;

import java.util.EventListener;

/* EventListener
 * - 이벤트 처리 규칙을 표시하는 용도.
 * - 메서드가 없다. 태깅용도.
 * - 즉, 이 인터페이스는 이벤트의 규칙을 정의한다는 사실을 표시.
 * 
 * 인터페이스
 * - 모든 메서드는 추상 메서드이다. 하위 클래스에서 반드시 구현해야 한다.
 *  	문법) public abstract 리턴타입 메서드명(파라미터 선언...);
 *   					 public abstract를 생략할 수 있다.
 *   
 *  - 모든 변수는 상수이다.
 *   	문법) public static final 타입 변수 = 값;
 */
public interface StateChangeListener extends EventListener {
	//> 인터페이스는 반드시 public이다. 규칙은 공개되어야 한다. 생략해도 public.
	/*public abstract*/ void stateChanged(StateChangeEvent e); 		
}
