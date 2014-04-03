package basic.exam01.Operator;

//////////////////////////////////////////////////////
//주제 : 연산자 - 산술 연산자
//////////////////////////////////////////////////////
//
//만든이 :		엄진영

/* 산술 연산자(Arithmetic operator)
* - 이항 연산자 (binary Operator)
*		: 연산을 수행하기 위하여 2개의 피연산자가 필요한 Operator를 말함.
*			+, -, *, /, %(나머지)
* - 예)
*			a + b, a * b, a % b
* 
* ## 잠시 용어 정리 ##
* # Operator - 연산자를 말함. ( +, -, *, / 등)
* # Operand - 피연산자를 말함. (a, b 등)
* 
* - 단항 연산자 (unary Operator)
*		: 연산을 수행하기 위하여 1개의 피연산자만이 필요한 Operator를 말함.
*			+, -, ++, --
* - 예)
*			+a, -a, ++a, --a, a++, a--
*
*/

//다음은 각각의 테스트가 주석으로 되어 있다. 
//하나씩 주석을 제거하여 테스트 해보기 바란다!
public class Operator01
{
	public static void main(String[] args)
	{
		/* 테스트 1 : 일반적인 연산 테스트
		int a = 10;
		int b = 20;
		int result = a + b;

		System.out.println("a + b = " + result);
		*/

		/* 테스트 2 : 나눗셈의 테스트. 중요!
		int a = 5;
		int b = 2;
		float result = a / b;

		System.out.println("a / b = " + result);
		 */
		// 해설 : 과연 어떤값이 나올 것인가?
		//		우리가 보통 생각하기를 5 / 2는 2.5일 것이고, 이 실수를 담기 위해서 
		//		float형 result 변수를 준비 했다. 
		//		그러나, 결과는 2.0 이 나온다!
		// 이유 : int 값과 int 값의 결과는 같은 data type인 int 값이다.
		//		연산은 같은 Data type 끼리만 가능하고 연산한 결과는 따라서, 
		//		그 Data type이 되는 것이다.
		//      위의 예제는 5 / 2의 결과는 int 값이 되어야 하므로 float형 변수 result에
		//		할당되기 전에 이미 소수점이하 값이 짤린 정수값 2 가 된다. 
		//
		// 에이~~ 강사님.. 그럼 int 값을 float형 변수에 담을 수 있습니까?
		// 오로지 같은 데이터 형 끼리만 연산이 가능하다고 하셨는데, 
		// 그럼 불가능하지 않습니까?
		// - 그렇다. 사실 불가능하다. 그러나, int값을 float형 변수에 넣기 위하여
		//   내부적으로 어떤 처리를 하게 되는데... 이것이 형 변환(type conversion)이다.
		//   이것에 대한 설명은 다음 예제에서 자세히 다루도록 하겠다!

	}
}