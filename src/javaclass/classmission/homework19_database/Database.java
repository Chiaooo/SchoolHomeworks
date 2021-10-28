package javaclass.classmission.homework19_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Chiao
 */
public class Database {
	Connection conn = null;

	public void databaseConnect(String url, String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.conn = DriverManager.getConnection(url + "?useSSL=false&serverTimezone=UTC", user, password);
	}

	public Connection getConn() {
		return conn;
	}
}
