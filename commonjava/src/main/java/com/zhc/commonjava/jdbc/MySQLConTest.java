package com.zhc.commonjava.jdbc;

//import java.math.BigDecimal;
import java.sql.*;

public class MySQLConTest {

	//mysql-connect-java-8.0.11.jar
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/shoppingmalldb?useSSL=false&serverTimezone=GMT%2B8";
	private static String dbUserName = "root";
	private static String dbPassword = "Huawei0..";
	private static String jdbcName = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		try {
			Class.forName(jdbcName);
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}

		Connection con = null;
		try {
			System.out.println("开始数据库连接");
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("数据库连接成功");

			Statement stmt = con.createStatement();

			/*
			 * System.out.println("下面进行插入操作"); String sql1 =
			 * "INSERT INTO staff_info (staffName,sex,phone,email,employedDate,department) VALUES ('Bill','S','19812345678','Bill@ddm.example.com','2017-01-01','Depart.A');"
			 * ; int rows = stmt.executeUpdate(sql1) ;
			 * System.out.println("插入操作执行完成，插入了"+rows+"条记录");
			 */

			System.out.println("下面进行查询操作");
			String sql2 = "SELECT * FROM product_table;";
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
//				BigDecimal id = rs.getBigDecimal(1);
				String name = rs.getString("name");
				Double price = rs.getDouble("price"); // 此方法比较高效
				System.out.println("查询结果：name: " + name + " price: " + price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("已经释放");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
