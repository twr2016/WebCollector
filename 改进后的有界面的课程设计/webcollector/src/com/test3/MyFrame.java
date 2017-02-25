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
	private JButton catchJB;// ץȡ��ť
	private JButton close;// �ر����ݿ����Ӱ�ť
	private JButton connect;// �������ݿⰴť
	private JButton play;// ��ӡ���ݿ����ݰ�ť
	private JTextArea titleShow;// ��ʾ��ץȡ��ҳ�ı���

	public MyFrame() {

		catchJB = new JButton("ץȡ");
		catchJB.setIcon(new ImageIcon("images/ץ��.png"));
		catchJB.setBorderPainted(false);

		connect = new JButton("�������ݿ�");
		connect.setIcon(new ImageIcon("images/���ݿ�����.png"));
		connect.setBorderPainted(false);

		close = new JButton("�ر����ݿ�����");
		close.setIcon(new ImageIcon("images/ɾ�����ݿ�����.png"));
		close.setBorderPainted(false);

		play = new JButton("��ӡ���ݿ�����");
		play.setIcon(new ImageIcon("images/��ӡ.png"));
		play.setBorderPainted(false);
		titleShow = new JTextArea();
		JFrame frame = new JFrame("webcollector�γ����   ������");
		JLabel object1 = new JLabel("���������ϸϸ�����£�");
		JPanel panel = new JPanel();
		Font font = new Font("TimesRoman", Font.PLAIN, 16);

		/*
		 * ��panel�ӵ�frame��
		 */
		frame.add(panel);
		frame.setLayout(null);
		frame.setSize(800, 685);
		frame.setResizable(false);

		panel.setLayout(null);
		panel.setSize(794, 650);

		/*
		 * ������ŵ�panel�����
		 */
		panel.add(connect);
		panel.add(catchJB);
		panel.add(object1);
		panel.add(titleShow);
		panel.add(close);
		panel.add(play);

		// �����λ����������

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
		// ��ץȡ����ҳ���ⳬ���ı���ʱ��ʾ������
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
