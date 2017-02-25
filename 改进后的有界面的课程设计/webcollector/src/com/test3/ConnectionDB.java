package com.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection getConnection(MyFrame myFrame, String userName, String password, long port) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			CatchThread.myFrame.getTitleShow().append("驱动加载失败！");
			// System.out.println("驱动加载失败！");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:" + port + "/webcollector?useUnicode=true&characterEncoding=UTF-8";
		try {
			// 建立数据库连接
			connection = DriverManager.getConnection(url, userName, password);
			// CatchThread.myFrame.getTitleShow().append("数据库连接成功！");
			CatchThread.myFrame.getTitleShow().append("数据库连接成功！\n");

		} catch (SQLException e) {
			CatchThread.myFrame.getTitleShow().append("数据库连接失败！\n");
			e.printStackTrace();
		}
		return connection;
	}

	public static void connectionClose(MyFrame myFrame, Connection c) {
		try {
			c.close();
			CatchThread.myFrame.getTitleShow().append("数据库连接关闭成功！\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// 关闭连接失败
			CatchThread.myFrame.getTitleShow().append("关闭数据库连接失败！\n");
			// System.out.println("关闭连接失败!");
			e.printStackTrace();
		}
	}

}
