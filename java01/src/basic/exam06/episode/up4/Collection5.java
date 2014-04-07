package basic.exam06.episode.up4;

import java.util.ArrayList;

// Java는 다중 상속을 지원하지 않는다.
// - ArrayList를 상속 받으면서 AbstractCollection을 상속 받을 수 없다.
@SuppressWarnings("serial")
public class Collection5 extends ArrayList<Object> /*implements Collection*/ {

/* 문제 발생!
* ArrayList로 부터 상속 받은 boolean add(Object value)와
* Collection의 void add(Object value)의 시그니처가 같지 않다
* => 컴파일 오류 발생
* 해결책: Collection6 참고
*/
}

// 메서드 시그너처 = 메소드 이름, 리턴타입, 파라미터 