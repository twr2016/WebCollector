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
				.append("--------����ץȡǰ������������ݿ�" + "��ť��ץȡ��ɺ󣬵�����ر����ݿ����ӡ���ť-------------\n");

	}

	public MyLittleFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(MyLittleFrame myFrame) {
		this.myFrame = myFrame;
	}

}
