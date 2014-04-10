package _0410_jdbc.am0910;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class CourseDao {
	DBConnectionPool dbConnectionPool;
	Connection con;
	PreparedStatement stmt;
	
	
	public void setConnection(DBConnectionPool dbConnectionPool) {
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
			

			
		}	catch (Throwable e){
			throw e;
		}	finally {
			try {
				stmt.close();
			}	catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	
	
	
}
