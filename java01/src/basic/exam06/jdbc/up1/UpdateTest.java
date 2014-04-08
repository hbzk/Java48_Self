package basic.exam06.jdbc.up1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/* 
 */
public class UpdateTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		
		/* update SE_SUBJS set TITLE='Java Basic' where SNO=1 */
		PreparedStatement stmt = con.prepareStatement("update SE_SUBJS set " 
				+ " TITLE=?"
				+ " where SNO=?");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("변경할 이름 입력: ");
		stmt.setString(1, scanner.nextLine());
		stmt.setInt(2, 1);
		
		stmt.executeUpdate();
		
		
		System.out.println("변경 성공!");
		
		scanner.close();
		
		stmt.close();
		con.close();
	}
}
