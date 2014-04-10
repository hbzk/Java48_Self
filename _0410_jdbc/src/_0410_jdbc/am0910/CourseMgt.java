package _0410_jdbc.am0910;


public class CourseMgt {
	static CourseDao dao = new CourseDao();
	
	public static void insert() throws Throwable {
		CourseVo cs = new CourseVo();
		cs.title = "a";
		cs.dest = "a";
		cs.hours = 11;
		
		dao.insertDao(cs);
		System.out.println("추가됨");
	}
	
	
	public static void main(String[] args) throws Throwable {
		DBConnectionPool dbConnectionPool = new DBConnectionPool();
		dao.setConnection(dbConnectionPool);
		
		
		insert();
		
		
		
		dbConnectionPool.closeAll();
	}
}
