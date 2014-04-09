package basic.exam06.jdbc.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
		
		PreparedStatement stmt = con.prepareStatement("delete from SE_SUBJS where SNO=?");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 번호 입력 : ");
		stmt.setInt(1, Integer.parseInt(scanner.nextLine()));
		
		stmt.executeUpdate();
		
		System.out.println("삭제 성공!");
		
		scanner.close();
		
		stmt.close();
		con.close();
	}
}
