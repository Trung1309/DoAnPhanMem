package com.doanphanmem.connect;

import java.sql.*;

public class DatabaseHelper {
	public static Connection openConnection() throws Exception {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;database=DTB_Nhom9_01116";
		String username = "sa";
		String password = "abc123";
		Connection conn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println(conn.getCatalog());
		return conn;
	}
	public static void main(String[] args) throws Exception {
		openConnection();
	}
}
