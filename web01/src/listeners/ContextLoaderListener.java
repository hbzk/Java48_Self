package listeners;

import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import controls.SubjectDeleteControl;
import controls.SubjectDetailControl;
import controls.SubjectInsertControl;
import controls.SubjectListControl;
import controls.SubjectUpdateControl;
import controls.auth.LoginControl;
import controls.auth.LogoutControl;
import util.DBConnectionPool;
import dao.MysqlSubjectDao;
import dao.MysqlUserDao;

/* PageController를 ServletContext에 보관함.
 * - PageController가 필요로 하는 의존 객체를 주입한 후에 보관한다.
 */
public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool dbConnectionPool;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized....");
		ServletContext sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		MysqlSubjectDao subjectDao = new MysqlSubjectDao();
		subjectDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectDao);
		
		MysqlUserDao userDao = new MysqlUserDao();
		userDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("userDao", userDao);
		
		SubjectListControl subjectListControl = new SubjectListControl();
		subjectListControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/list.bit", subjectListControl);
		
		SubjectDetailControl subjectDetailContol = new SubjectDetailControl();
		subjectDetailContol.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/detail.bit", subjectDetailContol);
		
		SubjectInsertControl subjectInsertControl = new SubjectInsertControl();
		subjectInsertControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/insert.bit", subjectInsertControl);
		
		SubjectUpdateControl subjectUpdateControl = new SubjectUpdateControl();
		subjectUpdateControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/update.bit", subjectUpdateControl);
		
		SubjectDeleteControl subjectDeleteControl = new SubjectDeleteControl();
		subjectDeleteControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/delete.bit", subjectDeleteControl);
		
		LoginControl loginControl = new LoginControl();
		loginControl.setUserDao(userDao);
		sc.setAttribute("/auth/login.bit", loginControl);
		
		LogoutControl logoutControl = new LogoutControl();
		sc.setAttribute("/auth/logout.bit", logoutControl);
	}
	

	
}
