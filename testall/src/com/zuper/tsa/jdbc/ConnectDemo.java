package com.zuper.tsa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDemo {

	public static void main(String[] args) {
		Connection conn = null;
		SQLException ex = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 注册Driver实现对象
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			String user = "root";
			String password = "hwc123";
			conn = DriverManager.getConnection(url, user, password);// 获取连接对象
			
			System.out.println(conn.isClosed() ? "连接已关闭" : "数据库已连接");
			// 数据库操作...
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			ex = e;
		} finally {
			if (conn != null) {
				try {
					conn.close(); // 关闭连接
				} catch (SQLException e) {
					if (ex == null) {//
						ex = e;
					}
				}
			}
			// 抛出SQLException
			if (ex != null) {
				throw new RuntimeException(ex);
			}
		}

	}

}
