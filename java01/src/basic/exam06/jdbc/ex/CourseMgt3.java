package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import basic.exam06.jdbc.up3.SubjectDao;
import basic.exam06.jdbc.up3.SubjectVo;

public class CourseMgt3 {
	static Connection con; 
	static PreparedStatement stmt;
	static Scanner sc = new Scanner(System.in);
	static CourseDao dao = new CourseDao();
	
	public static void insert(String title, String dest, int hours) throws Throwable {
		CourseVo cs = new CourseVo();
		cs.title = title;
		cs.description = dest;
		cs.hours = hours;
		
		dao.insert(cs);
	}
	
	public static void list() throws Throwable {
		int pageNo = 1, pageSize = 10;
		
		do {
			List<CourseVo> list = dao.list(pageNo, pageSize);
			System.out.println("[" + pageNo + "]-------------------------------");
			
			for (CourseVo course : list) {
				System.out.print(course.no + ", ");
				System.out.println(course.title);
				//System.out.print(course.title + ", ");
				//System.out.print(course.description + ", ");
				//System.out.println(course.hours);
			}
			System.out.println("-----------------------------------");
			System.out.print("출력할 페이지 : ");
			pageNo = Integer.parseInt(sc.nextLine());
			
		}	while (pageNo > 0);
		
	}
	
	public static void update(int no, String title, String dest, int hours) throws Throwable {
		
		CourseVo course = new CourseVo();
		
		course.no = no;
		course.title = title;
		course.description = dest;
		course.hours = hours;
		
		dao.update(course);
		
	}
	
	public static void delete(int no) throws Throwable {
		dao.delete(no);
	}
	
	public static void detail() throws Throwable {
		
		System.out.println("불러올 번호 입력 :");
		CourseVo course = dao.detail(Integer.parseInt(sc.nextLine()));
		
		System.out.print(course.no + ", ");
		System.out.print(course.title + ", ");
		System.out.print(course.description + ", ");
		System.out.println(course.hours);
		
		sc.close();
	}
	
	public static void main(String[] args) throws Throwable {
	  
	  // list();
	  // insert("qq", "qq", 123);
		// update(1, "hours", "title", 123);
		// delete(15);
		detail();
	  
		
		// list();

	  
  }
}
