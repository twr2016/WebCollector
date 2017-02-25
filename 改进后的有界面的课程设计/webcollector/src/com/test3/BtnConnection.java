package com.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnConnection implements ActionListener {

	private MyFrame myFrame;

	public BtnConnection(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Crawler.CON = ConnectionDB.getConnection(myFrame, Crawler.USERNAME, Crawler.PASSWORD, Crawler.PORT);
	}
}
