package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.200.79:3306/studydb", "study", "study");
		
		System.out.print("오호라.. 출력되었다..");
		con.close();
		
	}
}
