package basic.exam01.Variable;

//////////////////////////////////////////////////////
//주제 : 데이터형 - boolean
//////////////////////////////////////////////////////
//
//만든이 :		엄진영
//

/* << boolean >>
* - 용도 : true, false 값 저장.
* - JVM에서 내부적으로 true 는 1, false 는 0 의 값으로 취급한다.
*   내부적으로 1과 0의 int 값으로 저장된다고 해서 boolean 변수에 
*   직접 1 or 0 값을 저장할 수는 없다.
* - boolean 배열은 JVM에서 내부적으로 byte 배열을 사용한다.
*   원문내용
*	<In Sun's JDK releases 1.0 and 1.1, and the Java 2 SDK, Standard Edition, v1.2, 
*	 boolean arrays in the Java programming language are encoded as 
*	 Java virtual machine byte arrays, using 8 bits per boolean element.>
*   배열에 대해서는 따로 설명이 될 것이다.   
*
*/

public class Variable02
{
	public static void main(String[] args) 
	{
		boolean 관계1 = 4 > 5;  // false 값
		boolean 관계2 = !false; // true 값
		boolean 관계3 = (4 > 5) == false; // true 값;

		// 테스트 : 직접 1 또는 0을 할당한다면?
		//boolean 관계4 = 1;	// Error!

		System.out.println(관계1);
		System.out.println(관계2);
		System.out.println(관계3);
	}
}

/* boolean 값이 내부적으로 int 형의 값으로 저장된다고 했다.
* 이 값이 출력 될 때는, true(1) 은 "true" 문자열로
* false(0) 은 "false" 문자열로 변환되어 출력된다.
*
* 따라서, 예제의 출력결과는 1 과 0으로 출력되지 않는다.
*/
