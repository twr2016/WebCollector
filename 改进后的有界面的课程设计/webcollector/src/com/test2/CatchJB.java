package com.test2;

/*
 * 姓名:汤文茹
 * 班级：2014级5班
 * 学号：2014011771
 * 说明：网络爬虫课程设计*/
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
