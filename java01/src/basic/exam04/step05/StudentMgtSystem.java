package basic.exam04.step05;

import java.util.Scanner;
/* 클래스 변수 초기화 : static {} 블록
 * - 인스턴스 변수는 생성자를 통해 초기화 할 수 있다.
 * - 클래스 변수는? 스태틱 블록을 통해 초기화 할 수 있다.
 * 
 * 상수 변수의 사용
 * - 상수 값이 소스 코드의 여러 곳에서 사용된다면 유지보수를 용이하게 하기 위해,
 *   클래스 변수로 정의해 두는 것이 좋다. => 변경이 쉬워진다. 
 */

public class StudentMgtSystem {
	private static Scanner scanner = new Scanner(System.in);
	
	private static StudentScore[] scoreList;
	private static int scoreSize;

	// 상수 변수의 선언 => 인스턴스 마다 값이 다르지 않다. -> 클래스 변수로 만든다.
	// => 참조용(read only)이기 때문에 값을 바꿀 수 없도록 한다.
	//   => final 로 선언: 값을 한 번만 할당 가능!
	// => 파라미터 변수에 대해서도 값을 바꾸지 못하도록 
	private static final int SCORE_MAX_SIZE = 3;
	
	// static 블록은 클래스 변수를 초기화하는 용도로 사용한다.
	// 클래스 로딩 >> 클래스 변수 생성 및 초기화 문장 수행 >> static 블록 수행
	static {		/// 클래스 생성시 단 한번 생성, 클래스 변수 선언 사용에 용이
		scoreList = new StudentScore[SCORE_MAX_SIZE];
	}
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine();
		return input.split(" ");
	}
	
	// 실무에서는 좀 더 코드의 잘못된 사용을 방지하기 위해
	// 파라미터 변수에 대해 final로 선언한다. -> (final String value)
	/// 추후 value에 다른 값을 넣으려고 하면 컴파일러 오류 발생
	private static void executeAdd(final String value) {
	  String input;
	  
	  if (scoreSize < SCORE_MAX_SIZE) {
	  	// scoreList[scoreSize++] = StudentScore.fromCSV(value);		// >> 등록 y 선택시 추가를 위해 위치 이동
	  }	else {
	  	System.out.println("더 이상 추가할 수 없습니다.");
	  	return;
	  }
	  
	  // System.out.println("이름:" + scoreList[scoreSize  - 1].name); 		// >> 등록 y 선택시 추가를 위해 위치 이동
	  // System.out.println("국어:" + scoreList[scoreSize  - 1].kor);
	  // System.out.println("영어:" + scoreList[scoreSize  - 1].eng);
	  // System.out.println("수학:" + scoreList[scoreSize  - 1].math);
	  
		System.out.print("등록 하시겠습니까? (y/n)");
		input = scanner.nextLine();
	  if ("y".equals(input.toLowerCase())) {
	  	System.out.println("등록 되었습니다.");
	  	scoreList[scoreSize++] = StudentScore.fromCSV(value);
	  	
	  	System.out.println("이름:" + scoreList[scoreSize  - 1].name);
		  System.out.println("국어:" + scoreList[scoreSize  - 1].kor);
		  System.out.println("영어:" + scoreList[scoreSize  - 1].eng);
		  System.out.println("수학:" + scoreList[scoreSize  - 1].math);
		  
	  	
	  }	else {
	  	System.out.println("등록 취소 되었습니다.");
	  }
  }
	
	// >> list 출력 기능 구현
	public static void executeList() {
		// >> for (반복type 반복item : 반복대상) {		--> for each 사용문법 
		for (StudentScore score : scoreList) {
			// >> toString() 재정의를 했기 때문에 원하는 형태로 list 출력 가능
			System.out.println(score);
		}
	}
	
	public static void main(String[] args) {
		do {
			String[] values = promptCommand();

			if ("add".equals(values[0])) {
				executeAdd(values[1]);

			// >> list 출력 기능 추가
			} 	else if ("list".equals(values[0])) {
				executeList();
			}	else if ("quit".equals(values[0])) {
				break;
			}	else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}	while(true);
		scanner.close();
	}

}



