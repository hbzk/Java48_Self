package basic.training;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Training {
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Score> scoreList = new ArrayList<Score>();
	private static int scoreListSize;
	private static int SCORE_SIZE_MAX = 3;
	
	private static String[] prompt() {
		System.out.print("명령>");
		String input = scanner.nextLine();
		return input.split(" ");
	}
	
	private static void exeList() {
		for (Score sc : scoreList) {
			System.out.println(sc);
		}
	}
	
	private static void exeAdd(final String values) {
		
		System.out.print("등록? (y/n)" );
		String input = scanner.nextLine();
		
		if ("y".equals(input)) {
			Score sc = Score.fromCSV(values);
			
			System.out.println("이름" + sc.name);
			System.out.println("국어" + sc.kor);
			System.out.println("영어" + sc.eng);
			System.out.println("수학" + sc.math);
			
			scoreList.add(sc);
			System.out.println("등록 함");

		}	else {
			System.out.println("등록 취소 함");
		}
	}
	
	private static void exeSave() {
		try {
	    FileWriter out = new FileWriter("score.data");
	    // out.write(sc);
    } catch (IOException e) {
	    e.printStackTrace();
    } 
	}

	public static void main(String[] args) {
		do {
			String[] values = prompt();
			
			if ("add".equals(values[0])) {
				exeAdd(values[1]);
			}	else if ("list".equals(values[0])) {
				exeList();
			}	else if ("save".equals(values[0])) {
				exeSave();
			}	else if ("q".equals(values[0])) {
				System.out.println("종료 함");
				break;
			}	else{
				System.out.println("없는 명령임");
			}
		}	while(true);
		
		scanner.close();
	}

}
