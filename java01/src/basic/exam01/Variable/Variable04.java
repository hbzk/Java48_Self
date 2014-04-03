package basic.exam01.Variable;

//////////////////////////////////////////////////////
//주제 : 데이터형 - 문자형
//////////////////////////////////////////////////////
//
//만든이 :		엄진영
//

/* << 문자형 >>
* - 용도 : 문자에 해당하는 숫자코드값을 저장.
* - 크기 : 2바이트 양의 정수(0 ~ 65535)
*
* << 문자의 표현 >>
* - 문자는 컴퓨터에서 숫자로 인식된다. 즉, 각 문자에 대응하는 숫자를 지정해 놓고
*   이런 숫자를 사용하여 컴퓨터가 문자를 다루는 것이다.

* - 이렇게 문자에 대해 숫자를 대응시킨(매핑한) 것을 Character Set Table 이라 한다.
*   현재 우리가 사용하는 Character Set은 'ASCII' 라 불리우는 문자 집합이다.
*	 ASCII는 7bit로 128개의 문자를 정의 해놓고 있다. 실제적인 사용은
*   ASCII 에다가 서유럽 문자를 포함한 8bit ISO-Latin-1 Character Set을 이용한다.
*   우리는 이것을 흔히 8bit ASCII 라 부른다.

* - 한국, 중국, 일본등은 8bit로 문자를 표현할 수가 없다. 그래서, 16bit를 사용하여
*   문자를 표현한다. 그러나, 영어는 8bit, 아시아권 문자는 16bit 이렇게 혼영해서 
*   사용하다보니, 문자 처리하기도 까탈스럽고 문서 호환에서도 상당한 문제가 발생하였다.

* - 이러한 문제를 국제적으로 인식하여, 유니코드(UniCode)라는 국제적 표준 문자집합을
*   만들게 되었다. 현재 우리나라는 유니코드에서 현대 한글 음절에 대해 AC00 ~ D7A3
*   범위를 할당 받았다. 또한, 한중일 음성표기 및 기호, 한글자모 등에 대해 코드를
*   할당 받았다.
*	 
* - 자바언어에서는 기본적으로 유니코드를 사용하여 문자를 표현한다. 
*   따라서, 자바언어에서 변수명이나 메소드 명 등은 한글이나, 중국어 등과 같은 국가어로
*   표현할 수 가 있다. 
*
* - 본 강사는 예제에서 메소드나 변수명에 주로 한글을 사용하였으며,
*	 여러분들 또한 메소드명이나 변수명에 한글을 사용하기를 권한다. 
*   미국이나, 유럽에서는 영어로 변수를 만들면 자기네가 알아들으니까 사용하기 쉬울것이다.
*   그러나, 우리가 영어로 변수를 만들면, 나중에 알아보기도 어렵고, 혹 여러분들 중에서는
*   영어로 변수명을 만들기 위하여 한.영 사전을 뒤지는 분들도 계셨으리라...
*   한글로 변수명을 만들면 특별히 변수에 대한 주석을 달 필요도 없다. 변수명 그 자체가
*   이미 의미를 갖기 때문이다.
*   물론, 여러분이 만든 소스를 국제적으로 뿌릴려고 한다면 한글은 좀 문제가 되겠지만...
* 
* - 자바 언어에서의 문자의 표현
*	예) 문자 A 에대한 표현
*			'A' - 인용부호를 사용하여 표현한다.
*				  결과적으로, 대문자 A에 해당하는 유니코드 값을 의미한다.
*			'\u0041' - escape 문자 \ 와 u 를 사용하여 유니코드 값을 직접지정해도 된다.
*			0x0041 - 16진수 숫자를 사용하여 직접 표현해도 된다.
*			61 - 10진수 숫자를 사용하여 직접 표현해도 된다.
*			0101 - 8진수 숫자를 사용하여 직접 표현해도 된다.
*
* << 변수의 선언 >>
*	예)
*			char a = '가';
*	해설 : 
*		용도는 유니코드 숫자를 저장하기 위함, 크기는 2byte인 메모리를 만들고 그 메모리의
*		이름을 a 라고 한다. 그리고, 초기값으로 영어 대문자 A에 해당하는 유니코드 숫자값
*		0xAC00을 할당한다.
*
*/

import java.awt.*;

public class Variable04
{

	public static void main(String[] args) 
	{
		char 문자0 = '가';
		char 문자1 = '\uAC00';	// 유니코드값 지정
		char 문자2 = 0xAC00;		// 16진수 값 지정
		char 문자3 = 44032;		// 10진수 값 지정
		char 문자4 = 0126000;	// 8진수 값 지정

		System.out.println(문자0);
		System.out.println(문자1);
		System.out.println(문자2);
		System.out.println(문자3);
		System.out.println(문자4);
	}
}
