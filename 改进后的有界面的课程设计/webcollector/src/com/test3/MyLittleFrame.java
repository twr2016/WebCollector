package com.test3;


import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class MyLittleFrame extends JFrame {
	private JButton login;// ��½��ť
	private JTextArea userName;// �û��������
	private JPasswordField password;// ���������

	public MyLittleFrame() {

		login = new JButton("��½");
		login.setIcon(new ImageIcon("images/��½.png"));
		login.setBorderPainted(false);

		userName = new JTextArea("root");
		password = new JPasswordField("111111");
		JFrame frame = new JFrame("��½");
		JLabel object = new JLabel("�û�����");
		JLabel object1 = new JLabel("��   �룺");
		JPanel panel = new JPanel();
		Font font = new Font("TimesRoman", Font.PLAIN, 16);

		/*
		 * ��panel�ӵ�frame��
		 */
		frame.add(panel);
		frame.setLayout(null);
		frame.setSize(300, 300);
		frame.setResizable(false);

		panel.setLayout(null);
		panel.setSize(794, 650);

		/*
		 * ������ŵ�panel�����
		 */

		panel.add(object1);
		panel.add(object);
		panel.add(login);
		panel.add(userName);
		panel.add(password);

		// �����λ����������

		object.setFont(font);
		object.setBounds(20, 50, 70, 30);

		object1.setFont(font);
		object1.setBounds(20, 100, 100, 30);

		userName.setFont(font);
		userName.setBounds(80, 50, 150, 30);

		password.setFont(font);
		password.setBounds(80, 100, 150, 30);

		login.setFont(font);
		login.setBounds(100, 150, 100, 30);
		this.login.addActionListener(new BtnDriver(this));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JTextArea getUserName() {
		return userName;
	}

	public void setUserName(JTextArea userName) {
		this.userName = userName;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

}
