package jdbc.pm12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDao {
	DBConnectionPool dbConnectionPool;
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	public void setDBConnectionPool(DBConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}
	
	public void insertDao(CourseVo cs) throws Throwable {
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("insert SE_COURS (TITLE, DEST, HOURS) values (?, ?, ?)");
			stmt.setString(1, cs.title);
			stmt.setString(2, cs.dest);
			stmt.setInt(3, cs.hours);
			stmt.executeUpdate();
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {
				stmt.close();
			}	catch (Throwable e2){}
			dbConnectionPool.returnConnection(con);
		}
  }

	public void updateDao(CourseVo cs) throws Throwable {
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("update SE_COURS set TITLE=?, DEST=?, HOURS=? where CNO=?");
			stmt.setString(1, cs.title);
			stmt.setString(2, cs.dest);
			stmt.setInt(3, cs.hours);
			stmt.setInt(4, cs.no);
			stmt.executeUpdate();
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {
				stmt.close();
			}	catch (Throwable e2){}
			dbConnectionPool.returnConnection(con);
		}
  }

	public void deleteDao(int no) throws Throwable {
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("delete from SE_COURS where CNO=?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {
				stmt.close();
			}	catch (Throwable e2){}
			dbConnectionPool.returnConnection(con);
		}
  }
	
	public CourseVo detailDao(int no) throws Throwable {
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS where CNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				CourseVo cs = new CourseVo(); 
				cs.no = rs.getInt("CNO");
				cs.title = rs.getString("TITLE");
				cs.dest = rs.getString("DEST");
				cs.hours = rs.getInt("HOURS");
				return cs;
			}	else {
				return null;
			}
			
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {
				stmt.close();
			}	catch (Throwable e2){}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public ArrayList<CourseVo> listDao(int pageNo, int pageSize) throws Throwable {
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("select CNO, TITLE from SE_COURS order by CNO desc limit ?, ?");
			stmt.setInt(1, (pageNo -1) *pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			ArrayList<CourseVo> list = new ArrayList<CourseVo>();
			
			while (rs.next()) {
				CourseVo cs = new CourseVo(); 
				cs.no = rs.getInt("CNO");
				cs.title = rs.getString("TITLE");
				list.add(cs);
			}	
			return list;
			
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {
				stmt.close();
			}	catch (Throwable e2){}
			dbConnectionPool.returnConnection(con);
		}
	}
		
	
	
	
	
	
	
	
	
}
