package com.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.Statement;



//断开数据库连接
public class BtnPlay implements ActionListener {

	private MyFrame myFrame;

	public BtnPlay(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ResultSet rs = null;
		java.sql.ResultSetMetaData m = null;
		Statement stmt = null;
		try {

			stmt = Crawler.CON.createStatement();

			rs = stmt.executeQuery("select * from website");
			m = rs.getMetaData();

			// 打印内容
			int columns = m.getColumnCount();
			// 显示列,表格的表头
			myFrame.getTitleShow().append("\n");
			for (int i = 1; i <= columns; i++) {
				myFrame.getTitleShow().append(m.getColumnName(i) + "\t");
			}
			while (rs.next()) {
				myFrame.getTitleShow().append("\n");
				for (int i = 1; i <= columns; i++) {
					myFrame.getTitleShow().append(rs.getString(i) + "\t");
				}
			}
			myFrame.getTitleShow().append("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}