package basic.exam05.step02.ex;

import java.util.Scanner;

public class StudentMgtSystem {
	public static Scanner scanner = new Scanner(System.in);
	
	
	private static String promptCommand() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase();
	}
	

	public static void main(String[] arg) {
		do {
			String value = promptCommand();

			if ("1".equals(value)) {
				StudentControl.execute();
			} 	else if ("2".equals(value)) {
				StudentScoreControl.execute();
			}	else if ("list".equals(value)) {
				System.out.println("1 : 학생관리");
				System.out.println("2 : 점수관리");
				System.out.println("q : 종료");
			}	else if ("q".equals(value)) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}	while(true);
		scanner.close();
	}


}



