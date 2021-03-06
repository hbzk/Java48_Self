package basic.exam06.jdbc.up4;

import java.util.List;
import java.util.Scanner;

/* 소스를 손대지 않고 SubjectDao 구현체 교체하기.
 * - 애플리케이션 파라미터로 Dao 클래스 이름을 받는다.
 * 
 * JVM 프로퍼티를 사용하여 애플리케이션에게 값을 전달할 수 있다.
 * 문법 : java -D프로퍼티명=값 패키지명+클래스명 파라미터 파라미터 ...
 * 	c:>java -DsubjectDao=basic.exam06.jdbc.up4.MysqlSubjectDao SubjectMgt3
 */
public class SubjectMgt3 {
	static Scanner sc = new Scanner(System.in);
	static SubjectDao dao;
	
	public static void TestInsert() throws Throwable {
		SubjectVo subject = new SubjectVo();
		subject.title = "Java의 신";
		subject.description = "자바의 신을 존경할 수 있을 정도의 실력으로 향상시킴.";
		
		dao.insert(subject);
		
		System.out.println("등록 성공!!!");
	}
	
	public static void TestList() throws Throwable {
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
		
		SubjectVo subject = new SubjectVo();
		subject.no =  114;
		subject.title= "오호라 변경";
		subject.description = "내용도 변경하자.";
		
		dao.update(subject);
		System.out.println("변경 성공!");
		
	}
	
	public static void TestDelete() throws Throwable {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 번호 입력: ");
		dao.delete(Integer.parseInt(sc.nextLine()));
		
		System.out.println("삭제 성공!");
		
		sc.close();
	}
	
	public static void TestDetail() throws Throwable {
		
		System.out.println("불러올 번호 입력 :");
		SubjectVo subject = dao.detail(Integer.parseInt(sc.nextLine()));
		
		System.out.println(subject.no);
		System.out.println(subject.title);
		System.out.println(subject.description);
		
		sc.close();
	}
	
	public static void main(String[] args) throws Throwable { // > args == 애플리케이션 파라미터
		// -DSubjectDao=basic.exam06.jdbc.up4.MysqlSubjectDao
		String className = System.getProperty("SubjectDao");
		if (className != null) {
			Class clazz = Class.forName(className);
			dao = (SubjectDao) clazz.newInstance();
		}	else {
			throw new Exception("SubjectDao 구현체를 지정하지 않았다!");
		}
		
		// dao = new MysqlSubjectDao();
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
