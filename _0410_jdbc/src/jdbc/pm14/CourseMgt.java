package jdbc.pm14;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseMgt {
	static DBConnectionPool dbConnectionPool;
	static CourseDao dao;
	public void insert() {
		
	}
	
	
	
	
	public static void main(String[] args) throws Throwable {
		dbConnectionPool = new DBConnectionPool();
		dao.setDBConnection(dbConnectionPool);
		
		
		System.out.println("a");
		
		
		

		dbConnectionPool.closeAll();
	}

}
