package basic.exam01.Variable;

//////////////////////////////////////////////////////
//주제 : 변수의 선언 과 변수명(Indentifier)
//////////////////////////////////////////////////////
//
//만든이 :		엄진영
//

/* << 변수의 선언 >>
 * - Data를 저장하기 위한 메모리 생성을 의미.
 * - 저장할 Data의 "용도" 와 "크기"를 나타내는 Data 형을 지정하고 
 *   그 용도와 크기에 따라 만들어질 "메모리의 이름(변수명)"을 지정하면 된다.
 *		예) 용도는 '정수'를 담기위함,  "크기"는 1byte 정도의 값을 저장.
 *			byte    b;
 *			  |     |
 *			자료형  변수명
 *
 * - 같은 Data형의 변수 여러개를 한꺼번에 선언 할 수 있다.
 *		예) byte b1;
 *			byte b2;
 *			byte b3;
 *		--> 아래와 같이 한꺼번에 선언
 *			byte b1, b2, b3;
 * 
 * - 변수 선언과 더불어 초기화 할 수 있다.
 *		예1) byte b1;
 *			b1 = 100;
 *		--> 다음과 같이 변수선언과 초기화를 함께 할 수도 있다.
 *			byte b1 = 100;
 *
 *		예2) byte b1, b2, b3;
 *			 b1 = 10;
 *			 b2 = 20;
 *			 b3 = 30;
 *		--> 다음과 같이 여러변수의 선언과 초기화를 함께 할 수 있다.
 *			 byte b1 = 10, b2 = 20, b3 = 30;
 *		
 * << 변수 이름 짓기 >>
 * - 자바 언어가 사용하기 위해 확보한 단어(Reserved Keyword)는 사용할 수 없다.
 *		Reserved Keyword :
 *			abstract, boolean, break, byte, catch, char, class, const, continue,
 *			default, do, double, else, final, finally, float, for, goto, if, implements,
 *			import, instanceof, interface, long, native, new, package, private, protected,
 *			public, return, static, super, switch, synchronized, this, throw, throws, 
 *			transient, try, volatile, while
 * - 변수명의 첫 글자는 반드시 자바 문자가 와야 한다.
 *		자바문자 : A ~ Z, a ~ z, _, $, 기타 유니코드가 지원하는 다국어 문자.
 * - 첫글자를 제외 나머지 글자는 숫자(0 ~ 9)가 올 수 있다.
 * - 예)
 *			AtoZ, 정수2, _도움기술, $도움기술, _123, $234
 * 	
 * << 초기화 하지 않은 변수의 사용 >>
 * - 로컬 변수는 초기화 하지 않고 사용하면 컴파일시에 Error 발생
 * - 인스턴스 변수나 클래스 변수는 자동으로 초기화 된다.
 *   정수형: 0, 부동소수점: 0.0, 불린: false, 문자: 0
 */

public class Variable01
{
	public static void main(String[] args) 
	{
		// 기본적인 변수 선언 방법
		byte b1;	

		// 1. 테스트 (아래 문장을 주석풀고 테스트 해보라!) 
		//System.out.println("초기화 하지 않은 변수 b1 = " + b1); // 에러발생!
		/* 에러 메시지
		 * : variable b1 might not have been initialized
		 */

		// 변수의 초기화 
		b1 = 10;

		// 변수 선언과 초기화를 한꺼번에
		byte b2 = 20;

		// 여러개의 변수를 한번에 선언
		byte b3, b4, b5;

		// 여러개의 변수를 한번에 선언 및 초기화 
		byte b6 = 60, b7 = 70, b8 = 80;
		System.out.println(b6 + " , " + b7 + " , " + b8);

		// 변수 이름 짓기
		byte AtoZ;		// OK!
		byte 바이트1;	// OK!
		byte _123;		// OK!
		byte $123;		// OK!

		// 2. 테스트 (아래 문장을 주석풀고 테스트 해보라!)
		//byte 2바이트;	// Error! -> 변수명에 숫자가 먼저 올 수 없다.
	}
}

/* 이름 짓기에 대한 관례 (영어로 지을 때)
 * - 클래스명 : 일반적으로 명사, 첫문자는 대문자, 여러단어의 경우 각 단어의 시작은 대문자
 *			VariabeTest, String, Object ...
 * - 인터페이스명 : 클래스와 같으며, 보통 'able'을 붙여 데이터 형의 동작을 의미하기도 함
 *			MouseListener, LayoutManager, Cloneable, Runnable ...
 * - 메소드명 : 동사를 많이 사용. 첫문자는 소문자로 시작.
 *			setText, getName, getLength, paint ...
 * - 상수명 : 일반적으로 대문자로 표기. 여러 단어의 경우 각 단어의 구분을 '_' 로 연결.
 *			RED, TAG_BASE ...
 * - 변수명 : 일반적으로 소문자를 사용. 여러 단어의 경우, 대소문자 혼용해서 씀.
 *			index, name, 
 *		
 */