package com.test3;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {
	private JButton catchJB;// 抓取按钮
	private JButton close;// 关闭数据库连接按钮
	private JButton connect;// 连接数据库按钮
	private JButton play;// 打印数据库内容按钮
	private JTextArea titleShow;// 显示所抓取网页的标题

	public MyFrame() {

		catchJB = new JButton("抓取");
		catchJB.setIcon(new ImageIcon("images/抓手.png"));
		catchJB.setBorderPainted(false);

		connect = new JButton("连接数据库");
		connect.setIcon(new ImageIcon("images/数据库连接.png"));
		connect.setBorderPainted(false);

		close = new JButton("关闭数据库连接");
		close.setIcon(new ImageIcon("images/删除数据库连接.png"));
		close.setBorderPainted(false);

		play = new JButton("打印数据库内容");
		play.setIcon(new ImageIcon("images/打印.png"));
		play.setBorderPainted(false);
		titleShow = new JTextArea();
		JFrame frame = new JFrame("webcollector课程设计   汤文茹");
		JLabel object1 = new JLabel("本程序的详细细节如下：");
		JPanel panel = new JPanel();
		Font font = new Font("TimesRoman", Font.PLAIN, 16);

		/*
		 * 将panel加到frame中
		 */
		frame.add(panel);
		frame.setLayout(null);
		frame.setSize(800, 685);
		frame.setResizable(false);

		panel.setLayout(null);
		panel.setSize(794, 650);

		/*
		 * 将组件放到panel面板中
		 */
		panel.add(connect);
		panel.add(catchJB);
		panel.add(object1);
		panel.add(titleShow);
		panel.add(close);
		panel.add(play);

		// 各组件位置字体设置

		connect.setFont(font);
		connect.setBounds(80, 10, 140, 30);

		close.setFont(font);
		close.setBounds(360, 10, 170, 30);

		play.setFont(font);
		play.setBounds(550, 10, 170, 30);

		catchJB.setFont(font);
		catchJB.setBounds(240, 10, 100, 30);

		object1.setFont(font);
		object1.setBounds(10, 50, 600, 30);

		titleShow.setFont(font);
		titleShow.setBackground(Color.white);
		// 当抓取的网页标题超过文本域时显示滚动条
		JScrollPane titleJSP = new JScrollPane(titleShow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		titleJSP.setBounds(10, 100, 770, 500);
		panel.add(titleJSP);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.catchJB.addActionListener(new BtnListener(this));
		this.connect.addActionListener(new BtnConnection(this));
		this.close.addActionListener(new BtnClose(this));
		this.play.addActionListener(new BtnPlay(this));
		CatchThread.myFrame = this;
		frame.setVisible(true);

	}

	public JButton getClose() {
		return close;
	}

	public void setClose(JButton close) {
		this.close = close;
	}

	public JButton getConnect() {
		return connect;
	}

	public void setConnect(JButton connect) {
		this.connect = connect;
	}

	public JButton getPlay() {
		return play;
	}

	public void setPlay(JButton play) {
		this.play = play;
	}

	public JButton getCatchJB() {
		return catchJB;
	}

	public void setCatchJB(JButton catchJB) {
		this.catchJB = catchJB;
	}

	public JTextArea getTitleShow() {
		return titleShow;
	}

	public void setTitleShow(JTextArea titleShow) {
		this.titleShow = titleShow;
	}

}
