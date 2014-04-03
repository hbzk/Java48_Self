package basic.exam01.Variable;

//////////////////////////////////////////////////////
//주제 : 데이터형 - 부동소수점 : float, double
//////////////////////////////////////////////////////
//
//만든이 :		엄진영
//

/* 부동 소수점 
* - 으~~~ 생각만 해도 머리가 아프다... 아 이를 어떻게 설명해야 하는가?
* - 용도 : 부동소수점을 저장
*   크기 : 
*			float (32bit) : 유효자리수 7자리까지 정확하게 저장.
*			double(64bit) : 유효자리수 15자리까지 정확하게 저장.
*
* - 유효자리수 : 즉, 1234.567 에서 소수점을 뺀 숫자의 개수는 7개가 되는데
*				바로 이 개수가 유효자리수 이다. 유효자리수 범위에 있는
*				실수 값을 저장한다면, 다시 정확한 값으로 복원될 수 있다.
* - 만약 유효자리수 범위를 벗어난 실수를 저장하게 되면 저장은 되지만
*   출력해 보면, 원래의 값이 나오지 않고 반올림한 값으로 출력된다거나 한다.
*	 부동소수점에 대한 자세한 정보는 IEEE 754 문서를 참조하기 바란다.
*   검색엔진으로 한번 검색해 보라!
*
* - 내부적으로 float이나 double은 2진수로 다음과 같이 표현된다.
*	float : 32bit로 표현
*		1 bit - 부호비트(0 일경우 +, 1 일경우 - 를 의미)
*      8 bit - Exponent표현
*		23 bit - Significant(유효숫자)
*	double : 64bit로 표현
*		1 bit - 부호비트(0 일경우 +, 1 일경우 - 를 의미)
*      11 bit - Exponent표현
*		52 bit - Significant(유효숫자)
*
* - 정확히 어떻게 2진수로 메모리에 저장되는지 본인도 몰겄다... 혹 알고자 하는 분은
*   IEEE 754 문서를 참조하기 바란다. 검색엔진에서 "IEEE 754" 로 검색하여 참고 하기 바란다.
* 
* << 부동 소수점의 표현 >>
* - 고정 소수점 표현
*		1.32, 345.9, 9834.456
* - 부동 소수점 표현
*		234.8E1, 0.456E-5
*
* >> 32bit 실수값 표기
*	: 실수 표현 뒤에 접미사 f 나 F를 붙인다.
*	: 예) 123.45F, 456.34f 
*
* >> 64bit 실수값 표기(접미사 D or d 를 붙인다)
*	: 예) 123.45D, 456.34d, 456.466(접미사를 안붙여도 된다.)
*
* - float값은 접미사 f 또는 F를 붙여가지고 표현하지만, double 값은 접미사를 붙일 필요가
*   없다. 접미사를 붙인다는 것은 여러모로 불편하다. 즉, float 보다는 double을 많이
*   쓴다는 얘기다. 사실 7자리 가지고 어떤 실수를 표현하겠는가?
*   미국에서 연봉 몇십만 달러 받는 사람의 월급을 저장할 수 있겠는가? 
*   : 에이~~~ 강사님도.. 그건 long이나 int로 하면 되잖습니까?... 
*	 --> 헉~~~ 미국은 센트 단위도 있지 않은가? 보통 소수점 이하로 표현하지 않는가?
*	 : 음... 그럼 센트는 다른 int 형 변수를 따로 두어서 표현하면 되잖습니까?
*   --> 따지지 말라.... 어쨌든.. 7자리 갖고 실수를 표현하면 실수하기 안성 맞춤이다.
*	     웬만하면.. 실수는 double을 쓰기 바란다!
*
*/
public class Variable06 {
	public static void main(String args[]) {
		// 테스트 float
		// 유효자리수(7자리) 범위내의 값을 할당할 경우
		float 변수1 = 42224478F;
		float 변수2 = 987654.3f;
		float 변수3 = 9.876543f;

		// 유효자리수 범위를 초과하여 값을 할당할 경우
		float 변수4 = 987.65434436f;

		System.out.println(변수1);
		System.out.println(변수2);
		System.out.println(변수3);

		System.out.println(변수4);

		// 테스트 double
		// 유효 자리수(15자리) 범위내의 값을 할당할 경우
		double 변수5 = 987654321987654d;
		double 변수6 = 98765432198765.4;
		double 변수7 = 9.87654321987654;

		// 유효자리수 범위를 초과하여 값을 할당할 경우
		double 변수8 = 987.654321987654678;

		System.out.println(변수5);
		System.out.println(변수6);
		System.out.println(변수7);

		System.out.println(변수8);
	}
}