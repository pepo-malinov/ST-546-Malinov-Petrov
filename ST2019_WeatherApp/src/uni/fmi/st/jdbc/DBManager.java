package uni.fmi.st.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBManager {

	private static DBManager instance = new DBManager();
	private Connection con = null;

	private DBManager() {

	}

	public static DBManager getInstance() {
		return instance;
	}

	public void closeConnection() {
		if (null != con) {
			try {
				con.close();
				con = null;
				System.out.println("Connection is removed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Connection getConnection() {
		if (null == con) {
			try {
				Class.forName("org.h2.Driver");
				con = DriverManager.getConnection("jdbc:h2:~/test2", "sa", "");
				System.out.println("Connection is created!");
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

}
