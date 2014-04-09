package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import basic.exam06.jdbc.up3.SubjectVo;

public class CourseDao {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
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

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
			
			stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS" +
					" order by CNO desc" +
					" limit ?, ?");
			
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			
			rs = stmt.executeQuery();
			
			ArrayList<CourseVo> list = new ArrayList<CourseVo>();
			
			while(rs.next()) {
				CourseVo cs = new CourseVo();
				cs.no = rs.getInt("CNO");
				cs.title = rs.getString("TITLE");
				// cs.description = rs.getString("DEST");
				// cs.hours = rs.getInt("HOURS");
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
	
	public void update(CourseVo course) throws Throwable {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
			stmt = con.prepareStatement("update SE_COURS set" + 
			" TITLE=?" +
			", DEST=?" +
			", HOURS=?" +
			" where CNO=?");
			
			stmt.setString(1, course.title);
			stmt.setString(2, course.description);
			stmt.setInt(3, course.hours);
			stmt.setInt(4, course.no);
			stmt.executeUpdate();
			System.out.println("----- 변경 됨");

			
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public void delete(int no) throws Throwable {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
			stmt = con.prepareStatement("delete from SE_COURS where CNO=?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
			System.out.println("----- 삭제 됨");
			
		}	catch (Throwable e) {
			throw e; 
		}	finally {
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public CourseVo detail(int no) throws Throwable {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
			stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS" +
					" where CNO=?");
			
			rs = null;
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			
			if (rs.next()) { 	// > 여기서는 데이터를 가져왔는지 확인
				CourseVo course = new CourseVo();
				course.no = rs.getInt("CNO");
				course.title = rs.getString("TITLE");
				course.description = rs.getString("DEST");
				course.hours = rs.getInt("HOURS");
				return course;
			}	else {
				throw new Exception("해당 번호를 찾을 수 없습니다.");
			}
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {rs.close();}	catch (Throwable e2) {}
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	
	
	
}


