package javaclass.classmission.homework19_database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Chiao
 * @mission 编写一个应用程序，输入用户名和密码，访问test数据库中t_login表(字段包括id,username,password) 验证登陆是否成功
 */
public class Test {


	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Database database = new Database();
		Scanner in = new Scanner(System.in);

		database.databaseConnect("jdbc:mysql://localhost:3306/test", "root", "qweasd1234");

		System.out.println("请输入用户名和密码：");
		String username = in.nextLine();
		String password = in.nextLine();

		sql = "select * from t_login where username=? and password=?";
		PreparedStatement pstmt = database.getConn().prepareStatement(sql);

		pstmt.setString(1, username);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			System.out.println("登陆成功！");
		} else {
			System.out.println("登陆失败！");
		}

		sql = "select * from t_login";
		stmt = database.getConn().createStatement();

		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
	}
}
