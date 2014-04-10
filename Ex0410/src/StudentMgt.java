import java.util.ArrayList;
import java.util.Scanner;



public class StudentMgt {
	static DBConnectionPool dbConnectionPool;
	static StudentDao dao = new MySqlStudentDao();
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void insert() throws Throwable {
		StudentVo stud = new StudentVo();
		stud.no = 4;
		stud.comp = "3";
		stud.pos = "3";
		stud.stat = 0;
		stud.last = "3";
		stud.acct = "3";
		dao.insertDao(stud);
	}
	
	public static void update() throws Throwable {
		StudentVo stud = new StudentVo();
		stud.no = 3;
		stud.comp = "ㅃ";
		stud.pos = "ㄸ";
		stud.stat = 1;
		stud.last = "변ㅇ";
		stud.acct = "변경";
		dao.updateDao(stud);
	}
	
	public static void delete() throws Throwable {
		System.out.print("삭제할 번호:");
		dao.deleteDao(Integer.parseInt(sc.nextLine()));
	}
	
	public static void detail() throws Throwable {
		StudentVo st = new StudentVo();
		System.out.print("불러올 번호:");
		st = dao.detailDao(Integer.parseInt(sc.nextLine()));
		
		System.out.print(st.no + ", ");
		System.out.print(st.comp + ", ");
		System.out.print(st.pos + ", ");
		System.out.print(st.stat + ", ");
		System.out.println(st.acct);
		
	}
	
	public static void list() throws Throwable {
		ArrayList<StudentVo> stlist = new ArrayList<StudentVo>();
		int pageNo;
		int pageSize;
		pageNo = 1;
		pageSize = 2;
		do {
			stlist = dao.listDao(pageNo, pageSize);
			System.out.println("----------" + pageNo +"----------");
			for (StudentVo st : stlist) {
				System.out.print(st.no + ", ");
				System.out.print(st.comp + ", ");
				System.out.print(st.pos + ", ");
				System.out.print(st.stat + ", ");
				System.out.println(st.acct);
			}
			System.out.println("--------------------");
			System.out.print("페이지 번호: ");
			pageNo = Integer.parseInt(sc.nextLine());
		}	while (pageNo != 0);
		
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Throwable {
		dbConnectionPool = new DBConnectionPool(); 
		dao.setDBConnection(dbConnectionPool);
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
				delete();			break;
			case "detail" :
				detail();		break;
			case "list" :
				list();		break;
			case "q" :
				System.out.println("종료");		break;
			default :
				System.out.println("없는 명령");		break;
			}
		}	while (!"q".equals(command));
		
		dbConnectionPool.closeAll();
	}
}


// UNO,COMP,POS,STAT,LAST_SCH, ACCT
/* UNO,
 * COMP,
 * POS,
 * 
 * 
 * STAT,
 * LAST_SCH, 
 * ACCT
 */