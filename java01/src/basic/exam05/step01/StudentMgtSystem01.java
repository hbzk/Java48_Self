package basic.exam05.step01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/* FileWriter 사용
 * - 문자 데이터를 출력할 때 사용하는 클래스
 * - 문자 데이터 출력에 관련된 메서드가 들어 있다.
 * - 바이너리 데이터(메모장에서 편집 불가 데이터)의 출력은 
 *  FileOutputStream 클래스 사용
 */

public class StudentMgtSystem01 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();
	private static int scoreSize;

	private static final int SCORE_MAX_SIZE = 3;
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine();
		return input.split(" ");
	}
	
	private static void executeAdd(final String value) {
	  String input;
	  
	  StudentScore score = StudentScore.fromCSV(value);
	  
	  System.out.println("이름:" + score.name);
	  System.out.println("국어:" + score.kor);
	  System.out.println("영어:" + score.eng);
	  System.out.println("수학:" + score.math);
	  
		System.out.print("등록 하시겠습니까? (y/n) ");
		input = scanner.nextLine();
	  if ("y".equals(input.toLowerCase())) {
	  	scoreList.add(score);
	  	System.out.println("등록 되었습니다.");
	  }	else {
	  	System.out.println("등록 취소 되었습니다.");
	  }
  }
	
	public static void executeList() {
		int i = 0;
		for (StudentScore score : scoreList) {
			System.out.println(i++ + " : " + score);
		}
	}
	
	private static void executeDelete(int no) {
		if (no >= 0 && no < scoreList.size()) {
			scoreList.remove(no);
			System.out.println("삭제하였습니다.");
		}	else {
			System.out.println("유효하지 않은 번호입니다.");
		}
	}
	
	private static void executeUpdate(int no) {
		if (no >= 0 && no < scoreList.size()) {
			StudentScore score = scoreList.get(no);
			System.out.print("이름(" + score.name + "):");
			String input = scanner.nextLine();
			StudentScore temp = new StudentScore(input);
			
			System.out.print("국어(" + score.kor + "):");
			input = scanner.nextLine();
			temp.kor = Integer.parseInt(input);
			
			System.out.print("영어(" + score.eng + "):");
			input = scanner.nextLine();
			temp.eng = Integer.parseInt(input);
			
			System.out.print("수학(" + score.math + "):");
			input = scanner.nextLine();
			temp.math = Integer.parseInt(input);
			
			System.out.print("변경하시겠습니까? (y/n) ");
			input = scanner.nextLine();
			if ("y".equals(input.toLowerCase())) {
				scoreList.set(no, temp);
				System.out.println("변경 되었습니다");
			}	else {
				System.out.println("변경 취소 되었습니다");
			}
		}	else {
			System.out.println("유효하지 않은 번호입니다.");
		}
	}
	
	private static void executeSave() {
		try {
	    FileWriter out = new FileWriter("student.data"); 			// >> 프로젝트 폴더에 만들어진다.
			for (StudentScore score : scoreList) {
				out.write(score.toString() + "\n");
			}
			out.close(); 		// >> 입출력은 생성 후 닫는 습관.
			System.out.println("저장 되었습니다");
    } catch (Exception ex) {
	    ex.printStackTrace();
    }
	}
	
	public static void main(String[] args) {
		do {
			String[] values = promptCommand();

			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} 	else if ("list".equals(values[0])) {
				executeList();
			}	else if ("delete".equals(values[0])) {
				executeDelete(Integer.parseInt(values[1]));
			}	else if ("update".equals(values[0])) {
				executeUpdate(Integer.parseInt(values[1]));
			}	else if ("save".equals(values[0])) {
				executeSave();
			}	else if ("quit".equals(values[0])) {
				break;
			}	else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}	while(true);
		scanner.close();
	}


}



