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
	private JButton catchJB;// ץȡ��ť
	private JTextArea titleShow;// ��ʾ��ץȡ��ҳ�ı���

	public MyFrame() {
		catchJB = new JButton("ץȡ");
		catchJB.setIcon(new ImageIcon("images/ץ��.png"));
		catchJB.setBorderPainted(false);
		titleShow = new JTextArea();
		JFrame frame = new JFrame("webcollector�γ����   ������");
		JLabel object = new JLabel("����ұߵ�ץȡ��ť��ʼץȡ��ҳ�ɣ�");
		JLabel object1 = new JLabel("ץȡ����ҳ�������£�");
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
		panel.add(object);
		panel.add(catchJB);
		panel.add(object1);
		panel.add(titleShow);

		// �����λ����������
		object.setFont(font);
		object.setBounds(200, 10, 600, 30);

		catchJB.setFont(font);
		catchJB.setBackground(Color.pink);
		catchJB.setBounds(500, 10, 100, 30);

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
