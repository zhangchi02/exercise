package com.zhc.commonjava.jdbc;

import java.sql.*;

public class MySQLConTest {

	private static String dbUrl = "jdbc:mysql://192.168.0.133:8635/account_db";
	private static String dbUserName = "root";
	private static String dbPassword = "Huawei@12";
	private static String jdbcName = "com.mysql.jdbc.Driver";

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
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("数据库连接成功");
			
			Statement stmt = con.createStatement() ;
			
			/*System.out.println("下面进行插入操作");
			String sql1 = "INSERT INTO staff_info (staffName,sex,phone,email,employedDate,department) VALUES ('Bill','S','19812345678','Bill@ddm.example.com','2017-01-01','Depart.A');";
			int rows = stmt.executeUpdate(sql1) ;
			System.out.println("插入操作执行完成，插入了"+rows+"条记录");*/
			
			System.out.println("下面进行查询操作");
			String sql2 = "SELECT * FROM staff_info;";
			ResultSet rs = stmt.executeQuery(sql2) ;
			while(rs.next()){   
		         String name = rs.getString("staffName") ;   
		         String sex = rs.getString(2) ; // 此方法比较高效   
		         System.out.println("查询结果：staffName:"+name+" sex:"+sex);
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
