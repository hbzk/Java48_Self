import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MySqlStudentDao implements StudentDao {
	DBConnectionPool dbConnectionPool;
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void setDBConnection(DBConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}

	
	public void insertDao(StudentVo stud) throws Throwable {
		try {
			con = dbConnectionPool.getDBConnection(); 
			stmt = con.prepareStatement("insert into SE_STUDS (UNO,COMP,POS,STAT,LAST_SCH, ACCT) " + 
			"values(?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, stud.no);
			stmt.setString(2, stud.comp);
			stmt.setString(3, stud.pos);
			stmt.setInt(4, stud.stat);
			stmt.setString(5, stud.last);
			stmt.setString(6, stud.acct);
			stmt.executeUpdate();
			System.out.println("추가됨");
			
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2){}
			dbConnectionPool.returnDBConnection(con);
		}
  }
	
	public void updateDao(StudentVo stud) throws Throwable {
		try {
			con = dbConnectionPool.getDBConnection(); 
			stmt = con.prepareStatement("update SE_STUDS set COMP=?,POS=?,STAT=?,LAST_SCH=?, ACCT=? where UNO=?");
			
			stmt.setString(1, stud.comp);
			stmt.setString(2, stud.pos);
			stmt.setInt(3, stud.stat);
			stmt.setString(4, stud.last);
			stmt.setString(5, stud.acct);
			stmt.setInt(6, stud.no);
			
			stmt.executeUpdate();
			System.out.println("변경됨");
			
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2){}
			dbConnectionPool.returnDBConnection(con);
		}
  }
	
	public void deleteDao(int no) throws Throwable {
		try {
			con = dbConnectionPool.getDBConnection(); 
			stmt = con.prepareStatement("delete from SE_STUDS where UNO=?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
			System.out.println("삭제됨");
			
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2){}
			dbConnectionPool.returnDBConnection(con);
		}
  }
	
	public StudentVo detailDao(int no) throws Throwable {
		try {
			con = dbConnectionPool.getDBConnection(); 
			stmt = con.prepareStatement("select COMP,POS,STAT,LAST_SCH,ACCT,UNO from SE_STUDS where UNO=?");
			stmt.setInt(1, no);
			rs =	stmt.executeQuery();
			
			if (rs.next()) {
				StudentVo st = new StudentVo();
				st.comp = rs.getString("COMP");
				st.pos = rs.getString("POS");
				st.stat = rs.getInt("STAT");
				st.last = rs.getString("LAST_SCH");
				st.acct = rs.getString("ACCT");
				st.no = rs.getInt("UNO");
				return st;
			}	else {
				return null;
			}
			
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2){}
			dbConnectionPool.returnDBConnection(con);
		}
  }
	
	public ArrayList<StudentVo> listDao(int pageNo, int pageSize) throws Throwable {
		try {
			con = dbConnectionPool.getDBConnection(); 
			stmt = con.prepareStatement("select COMP,POS,STAT,LAST_SCH,ACCT,UNO from SE_STUDS order by UNO limit ?, ? ");
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			
			rs =	stmt.executeQuery();
			
			ArrayList<StudentVo> stlist = new ArrayList<StudentVo>();
			
			while (rs.next()) {
				StudentVo st = new StudentVo();
				st.comp = rs.getString("COMP");
				st.pos = rs.getString("POS");
				st.stat = rs.getInt("STAT");
				st.last = rs.getString("LAST_SCH");
				st.acct = rs.getString("ACCT");
				st.no = rs.getInt("UNO");
				stlist.add(st);
			}
			return stlist;
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2){}
			dbConnectionPool.returnDBConnection(con);
		}
  }
	
	
	
	
	
	
	
	
	
	
	
	
}

// "values(1, '비트나라', '부장', 1, '비트대학교', '111-11-11111')
/* 		stud.no = 3;
stud.comp = "3";
stud.pos = "3";
stud.stat = 0;
stud.last = "3";
stud.acct = "3";
*/