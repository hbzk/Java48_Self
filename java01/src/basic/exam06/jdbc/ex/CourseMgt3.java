package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseMgt3 {
	static Connection con; 
	static PreparedStatement stmt;
	public static void insert(String title, String dest, int hours) throws Throwable {
		CourseVo cs = new CourseVo();
		cs.title = title;
		cs.description = dest;
		cs.hours = hours;
		
		CourseDao dao = new CourseDao();
		dao.insert(cs);
	}
	
	public static void list() throws Throwable {
		int pageNo = 1, pageSize = 10;
		CourseDao dao = new CourseDao();
		
		do {
			List<CourseVo> list = dao.list(pageNo, pageSize);
			System.out.println("[" + pageNo + "]");
			
			for (CourseVo course : list) {
				System.out.print(course.no);
				System.out.print(course.title);
				System.out.print(course.description);
				System.out.print(course.hours);
			}
		}	while (pageNo > 0);
		System.out.println("-----------------------------");
	}
	
	public static void update(int cno, String column, String value) throws SQLException {
		stmt = con.prepareStatement("update SE_COURS set ?='?' where CNO=?");
		
		if (("TITLE").equals(column.toUpperCase())) {
			stmt.setString(1, column);
			stmt.setString(2, value);
			stmt.setInt(3, cno);
			stmt.executeUpdate();
			System.out.println("----- TITLE 변경 됨");
		}	else if (("DEST").equals(column.toUpperCase())) {
			stmt.executeUpdate("update SE_COURS set DEST='" + value + "' where CNO=" + cno + "");
			System.out.println("----- DEST 변경 됨");
		}	else if (("HOURS").equals(column.toUpperCase())) {
			stmt.executeUpdate("update SE_COURS set HOURS='" + value + "' where CNO='" + cno + "'");
			System.out.println("----- HOURS 변경 됨");
		}	else {
			System.out.println("----- 존재하지 않는 컬럼명입니다.");
		}
	}
	
	public static void delete(int cno) throws SQLException {
	  stmt = con.prepareStatement("delete from SE_COURS where CNO=?");
	  stmt.setInt(1, cno);
		stmt.executeUpdate();
		System.out.println("----- 삭제 됨");
	}
	
	public static void main(String[] args) throws Throwable {
	  Class.forName("com.mysql.jdbc.Driver");
	  con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");

	  
	  list();
	  
	  
	  // insert("qq", "qq", 123);
	  // update(6, "hours", "312312");
	  // delete(6);
	  
	  list();
	  
	  
	  
	  stmt.close();
	  con.close();
  }
}
