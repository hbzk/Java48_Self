import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBConnectionPool {
	ArrayList<Connection> list = new ArrayList<Connection>();
	
	public Connection getDBConnection() throws Throwable {
		if (list.size() > 0) {
			return list.remove(0);
		}	else {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		}
	}
	
	public void returnDBConnection(Connection con) {
		try {
	    if (!con.isClosed()) {
	    	list.add(con);
	    }
    } catch (Throwable e) {}
	}
	
	public void closeAll() {
		for (Connection con : list) {
			try {
	      con.close();
      } catch (SQLException e) {}
		}
	}
	
}