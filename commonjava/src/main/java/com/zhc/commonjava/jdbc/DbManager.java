package com.zhc.commonjava.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

	private static final String DBHOST = "49.4.23.221";
	private static final String DBPORT = "30006";
	private static final String DBNAME = "ShoppingMallDB";
	private static final String DBUSER = "apm";
	private static final String DBPWD = "paasapm";
	private static final String findAllProducts = "SELECT * FROM product_table";
	private static Connection conn = null;
	private static PreparedStatement prep = null;

	public DbManager() {
	}

	public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
//		String url = "jdbc:mysql://" + DBHOST + ":" + DBPORT + "/" + DBNAME+"?useSSL=false&serverTimezone=UTC";
		String url = "jdbc:mysql://" + DBHOST + ":" + DBPORT + "/" + DBNAME+"?useSSL=false";
		conn = DriverManager.getConnection(url, DBUSER, DBPWD);
		prep = conn.prepareStatement(sql);
		return prep;
	}

	public static void close(Connection conn, PreparedStatement prep) throws SQLException {
		if (prep != null) {
			prep.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public List<Item> findAllProducts() {
		List<Item> toReturn = new ArrayList<Item>();
		try {
			prep = DbManager.getPreparedStatement(findAllProducts);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				Double password = rs.getDouble("price");
				toReturn.add(new Item(id, name, password));
			}
		} catch (SQLException e) {
		} finally {
			try {
				DbManager.close(conn, prep);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return toReturn;
	}

	public static void main(String[] args) {
		List<Item> toReturn = new DbManager().findAllProducts();
		for (Item car : toReturn) {
			System.out.println(car.getName() + "----" + car.getPrice());
		}

	}
}
