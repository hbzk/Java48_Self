package basic.exam03;

/* 문자열 다루기
 * - C에서는 char[] 배열로 다룬다.
 * -  자바에서도 char[] 배열로 다룬다. 
 *  		-> 내부의 복잡한 명령어를 감추고(캡슐화) 
 *   		-> java.lang.String 클래스 제공
 */
public class Test01 {
	
	public static void main(String[] args) {
		// StringBuffer의 비교
		StringBuffer s1 = new StringBuffer("나는 홍길동이다.");
		StringBuffer s2 = new StringBuffer("나는 홍길동이다.");
		
		// 인스턴스가 같은지를 비교 => 주소가 같은지 비교
		if (s1 == s2) System.out.println("s1 == s2");
		
		// Object에서 상속받은 equals()를 재정의 하지 않았다. (내용물이 같은지 비교 불가)
		if (s1.equals(s2)) System.out.println("s1.equals(s2)");
	}
	
	public static void main08(String[] args) {
		// String의 비교
		String s1 = new String("나는 홍길동이다.");
		String s2 = new String("나는 홍길동이다.");
		
		// 인스턴스가 같은지를 비교 => 주소가 같은지 비교
		if (s1 == s2) System.out.println("s1 == s2");
		
		// 내용물이 같은지 비교 <= Object에서 상속받은 equals()를, 'String 클래스에서' 재정의 하였다.
		if (s1.equals(s2)) System.out.println("s1.equals(s2)");
	}
	
	public static void main07(String[] args) {
		// Heap에 있는 스트링 인스턴스를 Constant Pool에 복제하기
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.intern(); 			// 상수 풀에 복제한다.
		String s3 = "나는 홍길동이다.";
		
		if (s2 == s3) System.out.println("s2 == s3"); 
	}

	public static void main06(String[] args) {
		// 상수 스트링의 substring() 리턴 값?
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.substring(3);
		String s3 = s1.substring(3);
		
		if (s2 == s3) System.out.println("s2 == s3");		// 상수 스트링이라도 substring 값은 Heap 영역에 생성 됨
	}

	public static void main05(String[] args) {
		// 상수 스트링
		// - new String() 의 단축 명령이다.
		// - 상수 스트링으로 만든 인스턴스는 Constant Pool에 존재한다.
		// - 중복해서 생성되지 않는다. => 메모리 절약 위해서
		String s1 = new String("나는 홍길동이다.");
		String s2 = "나는 홍길동이다."; // => new String("나는 홍길동이다.")의 단축! 상수 스트링
		String s3 = "나는 홍길동이다.";
		
		System.out.println(s1);
		System.out.println(s2);
		
		if (s1 == s2) System.out.println("s1 == s2");
		if (s1 == s3) System.out.println("s1 == s3");
		if (s2 == s3) System.out.println("s2 == s3");
	}
	
	public static void main04(String[] args) {
		// mutable vs immutable 테스트
		// String 인스턴스의 값은 변경되지 않는다! => immutable
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.replace("홍길동", "임꺽정"); 		// 새 String 인스턴스 생성 후 리턴
		
		System.out.println(s1);
		System.out.println(s2);
		
		// StringBuffer 클래스: mutable
		StringBuffer s3 = new StringBuffer("나는 홍길동이다.");
		s3.replace(3, 6, "임꺽정");
		System.out.println(s3);
		
	}

	public static void main03(String[] args) {

		String s1 = new String("나는 홍길동이다.");
		
		System.out.println(s1.charAt(3));
		System.out.println(s1.indexOf("홍"));
		/* String 클래스 안에 있는 indexOf라는 메소드를 호출하는데, 
		 * indexOf의 숨겨진 변수 this에 s1의 주소값을 주고, 주소를 통해 해당 인스턴스(String 배열 객체)를 찾아서,
		 * indexOf 메소드의 파라미터 값 "홍" 글자를 찾아서 String 배열의 index 값을 출력한다. 
		 */
		String s2 = s1.substring(3); 	// 새 String 인스턴스를 생성하여 리턴
		String s3 = s1.substring(3); 	// 새 String 인스턴스를 생성하여 리턴
		System.out.println(s2);
		System.out.println(s3);
		if (s2 == s3) {
			System.out.println("s2 == s3");
		}	else {
			System.out.println("s2 != s3");		// 주소가 다르다.
		}
	}
	
	public static void main02(String[] args) {
		String s1 = new String("나는 홍길동이다.");
		String s2 = new String("나는 홍길동이다.");
		
		if (s1 == s2) {
			System.out.println("s1 == s2");
		} else {
			System.out.println("s1 != s2");
		}
	}
	
	public static void main01(String[] args) {
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1;
		String s3 = s2;
		
		System.out.println(s3);
	}

}
