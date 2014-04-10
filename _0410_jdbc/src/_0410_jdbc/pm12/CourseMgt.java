package _0410_jdbc.pm12;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseMgt {
	static CourseDao dao = new CourseDao();
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void insert() throws Throwable {
		CourseVo cs = new CourseVo();
		cs.title = "c";
		cs.dest = "c";
		cs.hours = 1;
		
		dao.insertDao(cs);
		System.out.println("추가됨");
	}
	
	public static void update() throws Throwable {
		CourseVo cs = new CourseVo();
		cs.title = "변경aaa";
		cs.dest = "경경";
		cs.hours = 1;
		cs.no = 140;
		
		dao.updateDao(cs);
		System.out.println("변경됨");
	}
	
	public static void delete() throws Throwable {
		System.out.print("삭제할 번호 입력: ");
		dao.deleteDao(Integer.parseInt(sc.nextLine()));
		System.out.println("삭제 됨");
	}
	
	public static void detail() throws Throwable {
		System.out.print("불러올 번호 입력: ");
		CourseVo cs = dao.detailDao(Integer.parseInt(sc.nextLine()));
		
		if (cs == null) {
			System.out.println("없는 번호.");
		}	else {
			System.out.print(cs.no + ", ");
			System.out.print(cs.title + ", ");
			System.out.print(cs.dest + ", ");
			System.out.println(cs.hours);
		}
	}
	
	public static void list() throws Throwable {
		ArrayList<CourseVo> list = null;
		int pageNo = 1;
		int pageSize = 10;
		
		do {
			list = dao.listDao(pageNo, pageSize);
			System.out.println("----------" + pageNo + "----------");
			for (CourseVo cs : list) {
				System.out.print(cs.no + ", ");
				System.out.println(cs.title);
			}
			System.out.println("--------------------");
			System.out.print("페이지 번호 입력: ");
			pageNo = Integer.parseInt(sc.nextLine());
		}	while (pageNo != 0);
		
	}
	
	public static void main(String[] args) throws Throwable {
		DBConnectionPool dbConnectionPool = new DBConnectionPool();
		dao.setDBConnectionPool(dbConnectionPool);
		
		String command;
		
		do {
			System.out.print("명령>");
			command = sc.nextLine();
			
			switch (command) {
			case "insert" :
				insert();		break;
			case "update" :
				update();		break;
			case "delete" :
				delete();		break;
			case "detail" :
				detail();		break;
			case "list" :
				list();		break;
			case "q" :
				System.out.println("종료");		break;
			default :
				System.out.println("없는메뉴");		break;
			}
		}	while (!"q".equals(command));
		
		dbConnectionPool.closeAll();
	}
}
