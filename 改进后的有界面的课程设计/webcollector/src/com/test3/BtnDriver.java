package com.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnDriver implements ActionListener {

	private MyLittleFrame myFrame;

	public BtnDriver(MyLittleFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		myFrame.setVisible(false);
		MyFrame mf = new MyFrame();
		CatchThread.setMyFrame(mf);
		CatchThread.getMyFrame().getTitleShow()
				.append("--------请在抓取前点击“连接数据库" + "按钮，抓取完成后，点击”关闭数据库连接“按钮-------------\n");

	}

	public MyLittleFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(MyLittleFrame myFrame) {
		this.myFrame = myFrame;
	}

}
