package com.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection getConnection(MyFrame myFrame, String userName, String password, long port) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// ��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			CatchThread.myFrame.getTitleShow().append("��������ʧ�ܣ�");
			// System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:" + port + "/webcollector?useUnicode=true&characterEncoding=UTF-8";
		try {
			// �������ݿ�����
			connection = DriverManager.getConnection(url, userName, password);
			// CatchThread.myFrame.getTitleShow().append("���ݿ����ӳɹ���");
			CatchThread.myFrame.getTitleShow().append("���ݿ����ӳɹ���\n");

		} catch (SQLException e) {
			CatchThread.myFrame.getTitleShow().append("���ݿ�����ʧ�ܣ�\n");
			e.printStackTrace();
		}
		return connection;
	}

	public static void connectionClose(MyFrame myFrame, Connection c) {
		try {
			c.close();
			CatchThread.myFrame.getTitleShow().append("���ݿ����ӹرճɹ���\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// �ر�����ʧ��
			CatchThread.myFrame.getTitleShow().append("�ر����ݿ�����ʧ�ܣ�\n");
			// System.out.println("�ر�����ʧ��!");
			e.printStackTrace();
		}
	}

}
