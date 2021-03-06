package basic.exam06.jdbc.up3;

import java.util.List;
import java.util.Scanner;

public class SubjectMgt {
	static Scanner sc = new Scanner(System.in);

	public static void TestInsert() throws Throwable {
		SubjectVo subject = new SubjectVo();
		subject.title = "Java의 신";
		subject.description = "자바의 신을 존경할 수 있을 정도의 실력으로 향상시킴.";
		
		SubjectDao dao = new SubjectDao();
		dao.insert(subject);
		
		System.out.println("등록 성공!!!");
	}
	
	public static void TestList() throws Throwable {
		SubjectDao dao = new SubjectDao();
		int pageNo = 1, pageSize = 10;
		
		do {
			List<SubjectVo> list = dao.list(pageNo, pageSize);
			System.out.println("[" + pageNo + "]-------------------------------------");
			
			for (SubjectVo subject : list) {
				System.out.print(subject.no + ", ");
				System.out.println(subject.title);
			}
			
			pageNo = Integer.parseInt(sc.nextLine());
			
		}	while(pageNo > 0);
		
	}
	
	public static void TestUpdate() throws Throwable {
		SubjectDao dao = new SubjectDao();
		
		SubjectVo subject = new SubjectVo();
		subject.no =  114;
		subject.title= "오호라 변경";
		subject.description = "내용도 변경하자.";
		
		dao.update(subject);
		System.out.println("변경 성공!");
		
	}
	
	public static void TestDelete() throws Throwable {
		SubjectDao dao = new SubjectDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 번호 입력: ");
		dao.delete(Integer.parseInt(sc.nextLine()));
		
		System.out.println("삭제 성공!");
		
		sc.close();
	}
	
	public static void TestDetail() throws Throwable {
		SubjectDao dao = new SubjectDao();
		
		System.out.println("불러올 번호 입력 :");
		SubjectVo subject = dao.detail(Integer.parseInt(sc.nextLine()));
		
		System.out.println(subject.no);
		System.out.println(subject.title);
		System.out.println(subject.description);
		
		sc.close();
	}
	
	public static void main(String[] args) throws Throwable {
		
		String command = null;
		
		do {
			try {
				System.out.print("명령>");
				command = sc.nextLine();
				switch (command) {
				case "insert":
					TestInsert(); break;
				case "list":
					TestList(); break;
				case "update":
					TestUpdate(); break;
				case "delete":
					TestDelete(); break;
				case "detail":
					TestDetail(); break;
				}
			}	catch (Throwable e) {} 	// 블록 안에서 예외가 발생하더라도 동작을 멈추지 않는다
		}	while (!"q".equals(command));
		sc.close();
	}

}
