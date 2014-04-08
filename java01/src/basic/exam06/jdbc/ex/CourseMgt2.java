package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMgt2 {
	static PreparedStatement stmt;
	static Connection con; 
	public static void insert(String title, String dest, int hours) throws SQLException {
		stmt = con.prepareStatement("insert SE_COURS(TITLE, DEST, HOURS)" +
				" value(?, ?, ?)");
		stmt.setString(1, title);
		stmt.setString(2, dest);
		stmt.setInt(3, hours);
		
		stmt.executeUpdate();
		System.out.println("----- 추가 됨");
	}
	
	public static void list() throws SQLException {
		stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("CNO") + ",");
			System.out.print(rs.getString("TITLE") + ",");
			System.out.print(rs.getString("DEST") + ",");
			System.out.println(rs.getString("HOURS"));
		}
		rs.close();
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
	
	public static void main(String[] args) throws Exception {
	  Class.forName("com.mysql.jdbc.Driver");
	  con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");

	  
	  list();
	  
	  
	  // insert("테스트1111", "검사", 123);
	  // update(6, "hours", "312312");
	  // delete(6);
	  
	  list();
	  
	  
	  
	  stmt.close();
	  con.close();
  }
}
