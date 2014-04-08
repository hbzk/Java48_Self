package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* select 요청
 * - executeQuery() 사용
 * - executeQuery()의 리턴값은 ResultSet 구현체이다.
 * 
 * ResultSet
 * - 서버에 준비된 결과를 하나씩 가져온다
 * - next() : 서버에 다음 데이터를 달라고 요청.
 *  							 가져올 데이터가 없다면 false를 리턴
 *  							 데이터를 가져왔다면 true 리턴
 */
public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		
		// Connection으로 부터 Statement 구현체를 얻는다.
		Statement stmt = con.createStatement();
		
		/* select SNO, TITLE, DEST from SE_SUBJS */
		// executeQuery()는 select 결과를 리턴하는 것이 아니다.
		// 결과를 가져올 수 있는 도구를 리턴한다.
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
