package basic.exam06.jdbc.self;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CourseMgt {
	static Scanner sc = new Scanner(System.in);
	static DBConnectionPool dbConnectionPool = new DBConnectionPool();
	static Connection con;
	static PreparedStatement stmt;
	
	public static void insert() throws Exception {
		con = dbConnectionPool.getConnection(); 
		stmt = con.prepareStatement("insert into SE_COURS (TITLE, DEST, HOURS) values (?, ?, ?)");
		stmt.setString(1, "aaa");
		stmt.setString(2, "www");
		stmt.setInt(3, 123);
		stmt.executeUpdate();
		
		System.out.println("추가됨");
		
		stmt.close();
	}
	
	public static void update() throws Exception {
		con = dbConnectionPool.getConnection(); 
		stmt = con.prepareStatement("update SE_COURS set TITLE=?, DEST=?, HOURS=? where CNO=20");
		stmt.setString(1, "zzz");
		stmt.setString(2, "www");
		stmt.setInt(3, 123);
		stmt.executeUpdate();
		
		System.out.println("변경됨");
		
		stmt.close();
	}

	public static void delete() throws Exception {
		con = dbConnectionPool.getConnection(); 
		stmt = con.prepareStatement("delete from SE_COURS where CNO=?");
		System.out.println("---- 삭제할 번호 입력");
		stmt.setInt(1, Integer.parseInt(sc.nextLine()));
		stmt.executeUpdate();
		
		System.out.println("삭제됨");
		
		sc.close();
		stmt.close();
	}
	
	public static void detail() throws Exception {
		con = dbConnectionPool.getConnection();
		stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS where CNO=?");
		System.out.println("---- 불러올 번호 입력");
		stmt.setInt(1, Integer.parseInt(sc.nextLine()));
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			System.out.print(rs.getInt("CNO") + ", ");
			System.out.print(rs.getString("TITLE") + ", ");
			System.out.print(rs.getString("DEST") + ", ");
			System.out.println(rs.getInt("HOURS"));
		}	else {
			System.out.println("없는 번호");
		}
		
	}
	
	public static void list() throws Exception {
		con = dbConnectionPool.getConnection();
		int pageNo = 1;
		int pageSize = 10; 
		
		stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS limit ?, ?");
		
		do {
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			ResultSet rs = stmt.executeQuery();
			
			System.out.println("----- " + pageNo + "페이지 -----");
			
			while (rs.next()) {
				System.out.print(rs.getInt("CNO") + ", ");
				System.out.print(rs.getString("TITLE") + ", ");
				System.out.print(rs.getString("DEST") + ", ");
				System.out.println(rs.getInt("HOURS"));
			}
			
			System.out.print("페이지 번호 입력 : ");
			pageNo = Integer.parseInt(sc.nextLine());
			
		}	while (pageNo != 0);
		
		
	}
	
	


	
	public static void main(String[] args) throws Exception {
		

		//insert();
		//update();
		//delete();
		//detail();
		//list();
		
		sc.close();
		dbConnectionPool.closeAll();
	}
}
