package basic.exam06.jdbc.self2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CourseMgt {
	static Connection con;
	static PreparedStatement stmt;
	static DBConnectionPool dbConnectionPool = new DBConnectionPool();
	static Scanner sc = new Scanner(System.in);
	
	public static void insert() throws Exception {
		con = dbConnectionPool.getConnection();
		stmt = con.prepareStatement("insert SE_COURS (TITLE, DEST, HOURS) value (?, ?, ?)");
		stmt.setString(1, "2");
		stmt.setString(2, "3");
		stmt.setInt(3, 4);
		stmt.executeUpdate();
		
		System.out.println("추가됨");
		
		stmt.close();
	}
	
	public static void update() throws Exception {
		con = dbConnectionPool.getConnection();
		stmt = con.prepareStatement("update SE_COURS set TITLE=?, DEST=?, HOURS=? where CNO=123");
		stmt.setString(1, "변경됨");
		stmt.setString(2, "ㅁㅁ");
		stmt.setInt(3, 4);
		stmt.executeUpdate();
		
		System.out.println("변경됨");
		
		stmt.close();
	}
	
	public static void delete() throws Exception {
		con = dbConnectionPool.getConnection();
		stmt = con.prepareStatement("delete from SE_COURS where CNO=?");
		
		System.out.print("삭제할 번호 입력: ");
		stmt.setInt(1, Integer.parseInt(sc.nextLine()));
		stmt.executeUpdate();
		
		System.out.println("삭제됨");
		
		stmt.close();
	}

	
	
	
	public static void main(String[] args) throws Exception {
		
		//insert();
		//update();
		delete();
		
		dbConnectionPool.closeAll();
	}
}
