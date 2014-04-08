package basic.exam06.jdbc.up1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* delete 요청
 * - executeDelete() 사용
 * 
 * delete sql
 * - delete form 테이블명 where 조건
 */
public class DeleteTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		
		Statement stmt = con.createStatement();
		
		/* update SE_SUBJS set TITLE='Java Basic' where SNO=1 */
		
		stmt.executeUpdate("delete from SE_SUBJS where SNO=6");
		
		System.out.println("삭제 성공!");
		
		stmt.close();
		con.close();
	}
}
