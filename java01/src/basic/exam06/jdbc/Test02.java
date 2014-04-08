package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* Statement 사용
 * - DBMS에 질의를 수행하는 역할
 * - executeQuery() : select 문 수행
 *  	- ececuteUpdate() : 
 *  	 	> SQL에서 DML (Data Manipulation Language)을 다룰 때 사용.
 *   	 	> create, drop, alter, insert, update, delete
 * - execute() : DDL(Data Definition Language), DML, DQL(Selector)
 * 
 * SQL - insert
 * insert 테이블명(컬럼명, 컬럼명, ...) value(값, 값, ...)
 * - 문자열 값은 ''기호 안에 작성한다. (""사용 불가)
 * - 숫자는 그냥 작성한다.
 */
public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		
		// Connection으로 부터 Statement 구현체를 얻는다.
		Statement stmt = con.createStatement();
		
		// DBMS에 질의하기
		// 서버에 질의할 insert문
		
		// insert SE_SUBJS(TITLE, DEST) value('Java기초', '자바 기초 문법 강의')
		stmt.executeUpdate(
				"insert SE_SUBJS(TITLE, DEST)"
				+ " values('Java_고급', '자바 고고 급')");
		
		System.out.println("입력 성공!");
		
		stmt.close();
		con.close(); 
	}
}
