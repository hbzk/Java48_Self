package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. java.jdbc.driver 구현체를 로딩 => JDBC 드라이버 관리자에 등록 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		// - Driver로 부터 직접 Connection 객체를 얻지 않는다.
		//  	-> DriverManager에게 요청 -> Driver의 connect() 호출
		//  	-> Driver는 Connection 객체를 리턴 -> DriverManager는 받은 것을 리턴.
		Connection con = DriverManager.getConnection( 	// > Connection 인터페이스의 참조변수에 객체를 저장 -> 코드의 유연성
				"jdbc:mysql://192.168.200.45:3306/studydb", 	// jdbc url
				"study", 	// user name
				"study"); 	// password
		
		System.out.print("오호라.. 출력되었다..");
		
		con.close(); // 서버에 연결 종료를 요청한다.
		// 만약, close()를 호출하지 않으면 서버는 타임아웃 될 때 까지 연결을 유지한다.
		
	}
}
