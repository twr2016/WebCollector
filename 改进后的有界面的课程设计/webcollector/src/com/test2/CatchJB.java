package com.test2;

/*
 * ����:������
 * �༶��2014��5��
 * ѧ�ţ�2014011771
 * ˵������������γ����*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatchJB implements ActionListener {

	private MyFrame myFrame;

	public CatchJB(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Thread(new CatchThread(this.myFrame)).start();
	}

}
