package basic.exam06.jdbc.self2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
	ArrayList<Connection> list = new ArrayList<Connection>();
	
	public Connection getConnection() throws Exception {
		if (list.size() > 0) {
			return list.remove(1);
		}	else {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://192.168.200.45:3306/studydb", "study", "study");
		}
	}
	
	public void returnConnection(Connection con) {
		list.add(con);
	}
	
	public void closeAll() {
		for (Connection con : list) {
			try {con.close();} catch (Exception e) {}
		}
	}
	
}
