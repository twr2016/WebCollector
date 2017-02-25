package com.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//断开数据库连接
public class BtnClose implements ActionListener {

	private MyFrame myFrame;

	public BtnClose(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ConnectionDB.connectionClose(myFrame, Crawler.CON);
	}

}
