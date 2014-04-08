package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* update 요청
 * - executeUpdate() 사용
 * 
 * update sql
 * - update 테이블명 set 컬럼명 = 값, 컬럼명 = 값, .. where 조건
 */
public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		
		Statement stmt = con.createStatement();
		
		/* update SE_SUBJS set TITLE='Java Basic' where SNO=1 */
		
		stmt.executeUpdate("update SE_SUBJS set " 
		+ " TITLE='Java update'"
		+ " where SNO=2");
		
		System.out.println("변경 성공!");
		
		stmt.close();
		con.close();
	}
}
