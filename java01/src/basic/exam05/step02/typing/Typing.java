package basic.exam05.step02.typing;

import java.util.ArrayList;
import java.util.Scanner;

public class Typing {
	static ArrayList<Score> scorelist = new ArrayList<Score>();
	
	private static void exeDel(int no) {
		scorelist.remove(no);
  }
	
	private static void exeList() {
/*		for (int i = 0; i < scorelist.length; i++) {
	    
    }
*/		System.out.println(scorelist);
  }

	private static void exeAdd(String inputVal) {
		Scanner scan = new Scanner(System.in);
		String[] val = inputVal.split(",");
		
		Score sc = new Score();
		
		sc.name = val[0];
		sc.kor = Integer.parseInt(val[1]);
		sc.eng = Integer.parseInt(val[2]);
		sc.math = Integer.parseInt(val[3]);
		sc.sum = sc.kor + sc.eng + sc.math;
		
		System.out.println("이름" + sc.name);
		System.out.println("국어" + sc.kor);
		System.out.println("영어" + sc.eng);
		System.out.println("수학" + sc.math);
		System.out.println("합계" + sc.sum);
		
		System.out.print("정말 등록? (y/n) ");

		if ("y".equals(scan.nextLine())) {
			scorelist.add(sc);
			System.out.println("등록 함");
		}	else {
			System.out.println("등록 취소함");
		}
	}
	
	private static void ScoreExecute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------");
		do {
		System.out.print("점수관리>");
		String[] val = scan.nextLine().split(" ");
		
			if ("add".equals(val[0])) {
				exeAdd(val[1]);
			}	else if ("list".equals(val[0])) {
				exeList();
			}	else if ("update".equals(val[0])) {
				System.out.println("변경-");
			}	else if ("del".equals(val[0])) {
				exeDel(Integer.parseInt(val[1]));
			}	else if ("save".equals(val[0])) {
				System.out.println("저장-");
			}	else if ("load".equals(val[0])) {
				System.out.println("불러오기-");
			}	else if ("menu".equals(val[0])) {
				break;
			}	else {
				System.out.println("없는 기능 입니다.");
			}
		} while(true);
  }
	
	// =========================================
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 : 점수관리");
		System.out.println("2 : 학생관리");
		System.out.println("q : 종료");
		do {
		System.out.print("메뉴>");
		String input = scan.nextLine();
		// String[] val = input.split(" ");
		
			if ("1".equals(input)) {
				ScoreExecute();
			}	else if ("2".equals(input)) {
				// StudentExecute();
				System.out.println("학생관리 - 준비중");
			}	else if ("q".equals(input)) {
				System.out.println("종료 됨");
				break;
			}	else if ("list".equals(input)) {
				System.out.println("1 : 점수관리");
				System.out.println("2 : 학생관리");
				System.out.println("q : 종료");
			}	else {
				System.out.println("없는 메뉴 입니다.");
			}
		} while(true);
		scan.close();
	}
}
