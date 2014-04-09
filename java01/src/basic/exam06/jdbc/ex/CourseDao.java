package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
	Connection con;
	PreparedStatement stmt;
	
	public void insert(CourseVo course) throws Throwable {
		
		try {
		  Class.forName("com.mysql.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		  
			stmt = con.prepareStatement("insert SE_COURS(TITLE, DEST, HOURS)" +
					" value(?, ?, ?)");
			stmt.setString(1, course.title);
			stmt.setString(2, course.description);
			stmt.setInt(3, course.hours);
			
			stmt.executeUpdate();
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	public List<CourseVo> list(int pageNo, int pageSize) throws Throwable {
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
			
			stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS" +
					" order by SNO desc" +
					" limit ?, ?");
			rs = stmt.executeQuery();
			
			ArrayList<CourseVo> list = new ArrayList<CourseVo>();
			
			while(rs.next()) {
				CourseVo cs = new CourseVo();
				cs.no = rs.getInt("CNO");
				cs.title = rs.getString("TITLE");
				cs.description = rs.getString("DEST");
				cs.hours = rs.getInt("HOURS");
				list.add(cs);
			}
			return list;
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {rs.close();}	catch (Throwable e2) {}
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	public CourseVo detail(int no) {
		return null;
	}
	
	public void update(CourseVo course) {

	}
	
	public void delete(int no) {

	}
	
	
}


