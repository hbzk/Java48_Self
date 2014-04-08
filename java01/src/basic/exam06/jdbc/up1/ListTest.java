package basic.exam06.jdbc.up1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 페이징 처리
 * 
 */
public class ListTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select SNO, TITLE, DEST from SE_SUBJS");
		
		// 서버에 결과 요청하기
		// rs.next();

		// 서버에서 가져온 데이터 중에서 원하는 컬럼 값을 꺼내기
		// getXXX() 호출 : XXX는 컬럼의 타입
		// 컬럼 타입과 일치하는 메서드를 사용하여 값을 꺼낸다.
		
		while(rs.next()) { 	// > 데이터가 있는동안 반복
			System.out.print(rs.getInt("SNO") + ",");
			System.out.print(rs.getString("TITLE") + ",");
			System.out.println(rs.getString("DEST"));
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}
