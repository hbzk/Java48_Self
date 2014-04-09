package basic.exam06.jdbc.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class SubjectDao {
	public void insert(SubjectVo subject) throws Throwable  {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
			
			stmt = con.prepareStatement(
					"insert SE_SUBJS(TITLE, DEST) value(?, ?)");
			
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.description);
			
			stmt.executeUpdate();
			
			
		}	catch (Throwable e) {
			throw e;
		}	finally { 	// try.. catch 블록을 나가기 전에 반드시 수행되는 블록
			// try 블록에서 준비한 작업을 마무리하는 명령어를 놓는다.
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	// > 여러 리스트(ArrayList, LinkedList ...)를 탄력적으로 저장할 수 있게 인터페이스로 형식 선언 
	public List<SubjectVo> list(int pageNo, int pageSize) {
		return null;
	}
	
	public SubjectVo detail(int no) {
		return null;
	}
	
	public void update(SubjectVo subject) {
		
	}
	
	public void delete(int no) {
		
	}
}
