package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import annotations.Component;
import vo.SubjectVo;

/* SubjectVo의 setter/getter 사용
 */
@Component
public class MysqlSubjectDao implements SubjectDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement("insert SE_SUBJS(TITLE, DEST) value(?, ?)");
			stmt.setString(1, subject.getTitle());
			stmt.setString(2, subject.getDescription());
			stmt.executeUpdate();
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	public List<SubjectVo> list(int pageNo, int pageSize) throws Throwable{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement("select SNO, TITLE from SE_SUBJS" +
					" order by SNO desc" +
					" limit ?, ?");
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			ArrayList<SubjectVo> list = new ArrayList<SubjectVo>();
			while(rs.next()) { 	// > 데이터가 있는동안 반복
				list.add(new SubjectVo()
				.setNo(rs.getInt("SNO"))
				.setTitle(rs.getString("TITLE")));
			}
			return list;
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {rs.close();}	catch (Throwable e2) {}
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	public SubjectVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement("select SNO, TITLE, DEST from SE_SUBJS" +
					" where SNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			if (rs.next()) { 	// > 여기서는 데이터를 가져왔는지 확인
				return new SubjectVo()
						.setNo(rs.getInt("SNO"))
						.setTitle(rs.getString("TITLE"))
						.setDescription(rs.getString("DEST"));
			}	else {
				throw new Exception("해당 번호를 찾을 수 없습니다.");
			}
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {rs.close();}	catch (Throwable e2) {}
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	public void update(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement("update SE_SUBJS set " 
					+ " TITLE=?"
					+ ", DEST=?"
					+ " where SNO=?");
			stmt.setString(1, subject.getTitle());
			stmt.setString(2, subject.getDescription());
			stmt.setInt(3, subject.getNo());
			stmt.executeUpdate();
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}
	
	public void delete(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement("delete from SE_SUBJS where SNO=?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		}	catch (Throwable e) {
			throw e;
		}	finally {
			try {stmt.close();}	catch (Throwable e2) {}
			try {con.close();}	catch (Throwable e2) {}
		}
	}

}


