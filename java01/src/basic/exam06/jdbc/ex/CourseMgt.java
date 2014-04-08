package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseMgt {
	static Connection con;
	static Statement stmt;
	
	public static void insert(String title, String dest, int hours) throws SQLException {
		stmt.executeUpdate("insert SE_COURS(TITLE, DEST, HOURS)" +
				" value('" + title + "', '" + dest + "', '" + hours + "')");
		System.out.println("----- 추가 됨");
	}
	
	public static void list() throws SQLException {
		ResultSet rs = stmt.executeQuery("select CNO, TITLE, DEST, HOURS from SE_COURS");
		while(rs.next()) {
			System.out.print(rs.getInt("CNO") + ",");
			System.out.print(rs.getString("TITLE") + ",");
			System.out.print(rs.getString("DEST") + ",");
			System.out.println(rs.getString("HOURS"));
		}
		rs.close();
	}
	
	public static void update(int cno, String column, String value) throws SQLException {
		
		if (("TITLE").equals(column.toUpperCase())) {
			stmt.executeUpdate("update SE_COURS set TITLE='" + value + "' where CNO=" + cno + "");
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
		stmt.executeUpdate("delete from SE_COURS where CNO=" + cno + "");
		System.out.println("----- 삭제 됨");
	}
	
	public static void main(String[] args) throws Exception {
	  Class.forName("com.mysql.jdbc.Driver");
	  con = DriverManager.getConnection("jdbc:mysql://192.168.200.42:3306/studydb", "study", "study");
	  stmt = con.createStatement();
	  
	  list();
	  
	  
	  // insert("테스트123" + i, "홍길동", 00123);
    
  	
	  // update(6, "hours", "00123");
	  // delete(5);
	  
	  list();
	  
	  
	  
	  stmt.close();
	  con.close();
  }
}
