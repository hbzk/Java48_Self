package basic.exam04.step03;

import java.util.Scanner;
/* StudentScore 클래스의 개선
 * - 콤마(,)를 포함하는 문자열로부터 StudentScore 인스턴스를 생성하기
 * - static 메서드(클래스 메서드)의 활용법 소개 
 */

public class StudentMgtSystem {
	private static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine();
		return input.split(" ");
	}

	private static void executeAdd(String value) {
	  String input;
	  
		/// ================>>> StudentScore.java
	  /// 데이터 항목이 추가되거나, 문자열의 표현 순서가 바뀌더라도 소스코드를 유지보수 하기가 쉽다.
		/// <<<================ StudentScore.java
	  StudentScore score = StudentScore.fromCSV(value);
	  System.out.println("이름:" + score.name);
	  System.out.println("국어:" + score.kor);
	  System.out.println("영어:" + score.eng);
	  System.out.println("수학:" + score.math);
	  input = scanner.nextLine();
	  if ("y".equals(input.toLowerCase())) {
	  	System.out.println("등록 되었습니다.");
	  }	else {
	  	System.out.println("등록 취소 되었습니다.");
	  }
  }

	public static void main(String[] args) {
		do {
			String[] values = promptCommand();

			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			}	else if ("quit".equals(values[0])) {
				break;
			}	else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}	while(true);
		scanner.close();
	}

}

