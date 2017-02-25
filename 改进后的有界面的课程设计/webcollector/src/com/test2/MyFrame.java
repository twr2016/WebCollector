package com.test2;

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
	private JTextArea titleShow;// 显示所抓取网页的标题

	public MyFrame() {
		catchJB = new JButton("抓取");
		catchJB.setIcon(new ImageIcon("images/抓手.png"));
		catchJB.setBorderPainted(false);
		titleShow = new JTextArea();
		JFrame frame = new JFrame("webcollector课程设计   汤文茹");
		JLabel object = new JLabel("点击右边的抓取按钮开始抓取网页吧！");
		JLabel object1 = new JLabel("抓取的网页标题如下：");
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
		panel.add(object);
		panel.add(catchJB);
		panel.add(object1);
		panel.add(titleShow);

		// 各组件位置字体设置
		object.setFont(font);
		object.setBounds(200, 10, 600, 30);

		catchJB.setFont(font);
		catchJB.setBackground(Color.pink);
		catchJB.setBounds(500, 10, 100, 30);

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
		this.catchJB.addActionListener(new CatchJB(this));

		frame.setVisible(true);

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
