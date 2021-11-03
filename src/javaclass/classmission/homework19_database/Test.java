package javaclass.classmission.homework19_database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Chiao
 * @mission 编写一个应用程序，输入用户名和密码，访问test数据库中t_login表(字段包括id,username,password) 验证登陆是否成功
 */
public class Test {


	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
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
			sql = "select * from t_login";
			stmt = database.getConn().createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
						+ rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
			}
		} else {
			System.out.println("登陆失败！");
		}

		sql = "insert into t_login(username,password,sex,birthday) value(?,?,?,?) ";

		System.out.println("请输入你要添加的用户名，密码，性别以及生日(yyyy-MM-dd)：");
		username = in.nextLine();
		password = in.nextLine();
		String sex = in.nextLine();

		String birthday = in.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(birthday);

		pstmt = database.getConn().prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, sex);
		pstmt.setDate(4, new java.sql.Date(date.getTime()));

		pstmt.execute();

		System.out.println("插入成功！，新的数据信息如下");
		sql = "select * from t_login";
		stmt = database.getConn().createStatement();
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
					+ rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
		}

	}
}
