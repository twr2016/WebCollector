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
	private JButton login;// 登陆按钮
	private JTextArea userName;// 用户名输入框
	private JPasswordField password;// 密码输入框

	public MyLittleFrame() {

		login = new JButton("登陆");
		login.setIcon(new ImageIcon("images/登陆.png"));
		login.setBorderPainted(false);

		userName = new JTextArea("root");
		password = new JPasswordField("111111");
		JFrame frame = new JFrame("登陆");
		JLabel object = new JLabel("用户名：");
		JLabel object1 = new JLabel("密   码：");
		JPanel panel = new JPanel();
		Font font = new Font("TimesRoman", Font.PLAIN, 16);

		/*
		 * 将panel加到frame中
		 */
		frame.add(panel);
		frame.setLayout(null);
		frame.setSize(300, 300);
		frame.setResizable(false);

		panel.setLayout(null);
		panel.setSize(794, 650);

		/*
		 * 将组件放到panel面板中
		 */

		panel.add(object1);
		panel.add(object);
		panel.add(login);
		panel.add(userName);
		panel.add(password);

		// 各组件位置字体设置

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
