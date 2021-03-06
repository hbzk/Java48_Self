package basic.exam01.Array;

//////////////////////////////////////////////////////
//주제 : 참조 변수 와 배열
//////////////////////////////////////////////////////
//
//만든이 :		엄진영

/* >> 참조 변수!
* - 자바에서 포인터가 없다고 하지만...허~~~ 정말 없어졌을까?
*	 단지, 역할이 축소되었을 뿐이다.
* - reference 형에는 3가지가 있다.
*		class 형, interface 형, array 형
* - reference 값은 객체에 대한 포인터(주소) 이다.
* - 객체는 동적으로 생성된 class의 instance, array 그리고 interface를 구현한 배열이나 
*	 클래스의 인스턴스를 말한다.
* - 객체는 heap 이라고 불리우는 메모리상에 생성되며, 더 이상 그 객체를 참조하는
*   참조 변수가 없다면 가비지 컬렉터에 의해 수집된다.
* - 자바의 객체는 C++과 같은 언어처럼 명시적으로 free(해제)할 수 없다.
*	 또한, 재생할 수 없다.
* - 객체의 생성은 new 명령어를 사용한다.
* ==> 결론적으로, 참조변수는 객체의 주소를 담는 변수이다.
*   
* >> 배열
* - 같은 데이터형 값을 여러개 저장하기 위하여, 연속적으로 이어진, 같은 데이터 형의 
*   메모리를 만드는 것!
* - 국어, 영어, 수학 과목의 점수를 저장하기 위하여 int 형 변수 3개를 선언하면 된다.
*			int 국어, 영어, 수학;
*   쩝.. 그러나, 만약 과목이 19개 정도 된다면..허~~~~ 변수 만들기도 만만찮은
*   일이 될 것이다. 또한, 사용할 때도 변수명이 다 틀리니까..허~~~ 그것도 만만잖네..그려..
* - 자~~~ 배열이 왔습니다! 배열이... 아주 사용하기 쉽고~~ 다루기 쉬운 배열이 왔어요~~~
* - 사용방법
*		배열 선언 : 만약, 위에서 얘기한 19과목의 정수형 점수를 저장하고 싶다면?
*		1) 먼저 배열 객체의 주소를 담을 참조변수를 선언한다.
*			방법 1 -> int[] a = null;
*			방법 2 -> int a[] = null;
*		: [방법 1]은 자바에서 권장하는 방식이다. [방법 2]는 C, C++ 방법과 유사하다.
*
*	%% 'null' 값은 객체가 없음을 나타내는 reference 값이다. 참조변수를 초기화하는데
*		사용한다.
*
*		2) 배열 객체를 만들어 참조변수에 할당한다.
*			a = new int[10];
*		: int 형 메모리 10개를 만들고, 참조변수 'a'에 할당한다.
*		  즉, 배열 객체의 주소를 변수 'a'에 할당한다고 보면된다.
*		
*		3) 준비됐나?... 준비됐다... 드뎌 사용을 해보자!
*			a[0] = 10;
*			a[1] = 100;
*		: 배열 참조변수 'a' 에대해 '[]'를 사용하여 인덱스를 지정해 주고, 값을 할당한다.
*		  즉, 위의 예는 참조변수 'a'가 가르키는 배열객체의 0번째 항목에 10을 할당하고
*		  1번째 항목에 100 값을 할당하라는 뜻이된다.
* 	
*/

public class Array01 /*extends Object */
{
	public static void main(String[] args) 
	{
		/* 배열 객체를 가르킬 참조변수를 만들고, null 값으로 초기화한다.*/
		int[] 과목 = null;
		과목 = new int[19];

		for(int i = 0; i < 10; i++)
			과목[i] = 10 * i;

		for(int i = 0; i < 10; i++)
			System.out.println("과목[" + i + "] = " + 과목[i]);

		/* '과목' 참조변수가 다른 배열을 가르키도록 하자!*/
		과목 = new int[10];

		for(int i = 0; i < 10; i++)
			과목[i] = 100 * i;

		for(int i = 0; i < 10; i++)
			System.out.println("과목[" + i + "] = " + 과목[i]);

		/* int 형 메모리 10개를 새로 만들고, 과목은 그 배열을 참조한다.
		 * 그럼... 이전에 만든 int 형 19개 배열 객체는 어떻게 되었을까?
		 * - 그 배열의 주소를 잃어 버렸으니 더이상 그 배열을 사용할 방법이 없지 않은가?
		 *   그러면... 어쩔수 없이 쓰레기 메모리로 취급 되어, 가비지 컬렉터에 의해 
		 *   수집된다. 물론..지금 당장 수집되는 것은 아니고... 
		 *   우리가 신경쓸거 없이.. 수집기가 알아서 하겠지모... ^-^...
		 *   쓰레기 수집기(garbage collector)에 대해선는 "객체지향 프로그래밍" 편에서
		 *   다루기로 하겠다! 
		 */
	}
}