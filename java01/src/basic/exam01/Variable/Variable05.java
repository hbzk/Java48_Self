package basic.exam01.Variable;

//////////////////////////////////////////////////////
//주제 : 데이터형 - 문자형 : Escape Sequence
//////////////////////////////////////////////////////
//
//만든이 :		엄진영
//

/* 제어문자열(Escape Sequence)
* - 문자 \ 를 사용하여 문자로서의 기능보다는 제어하는 기능으로서 사용할 수 있다.
* - 제어 문자열 테이블
*		
*		제어문자열			의미						유니코드
*			\b			Backspace					\u0008
*			\t			Horizontal TAB				\u0009
*			\n			Line Feed					\u000a
*			\f			Form Feed					\u000c
*			\r			Carriage Return				\u000d
*			\"			double quote				\u0022
*			\'			single quote				\u0027
*			\\			backslash					\u005c
*
*/

//아래의 소스를 도스창으로 실행 시켜 보라!
public class Variable05
{
	public static void main(String[] args) 
	{
		char 제어문자1 = '\b';
		char 제어문자2 = '\t';
		char 제어문자3 = '\n';
		char 제어문자4 = '\f';
		char 제어문자5 = '\r';
		char 제어문자6 = '\"';
		char 제어문자7 = '\'';
		char 제어문자8 = '\\';

		System.out.println("Backspace : ABC" + 제어문자1 + "DEF");
		System.out.println("Horizontal TAB : ABC" + 제어문자2 + "DEF");
		System.out.println("Line Feed : ABC" + 제어문자3 + "DEF");
		System.out.println("Form Feed : ABC" + 제어문자4 + "DEF");
		System.out.println("Carriage Return : ABC" + 제어문자5 + "DEF");
		System.out.println("double quote : ABC" + 제어문자6 + "DEF");
		System.out.println("single quote : ABC" + 제어문자7 + "DEF");
		System.out.println("backslash : ABC" + 제어문자8 + "DEF");
	}
}
