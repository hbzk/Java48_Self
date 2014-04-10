import java.util.ArrayList;


public interface StudentDao {
	
	public void setDBConnection(DBConnectionPool dbConnectionPool);

	
	public void insertDao(StudentVo stud) throws Throwable;
	
	public void updateDao(StudentVo stud) throws Throwable;
	
	public void deleteDao(int no) throws Throwable;
	
	public StudentVo detailDao(int no) throws Throwable;
	
	public ArrayList<StudentVo> listDao(int pageNo, int pageSize) throws Throwable;
	
	
}
