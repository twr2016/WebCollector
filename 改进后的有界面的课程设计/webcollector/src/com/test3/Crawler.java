package com.test3;

/*
 * ������������
 * �༶��2014��5��
 * ѧ�ţ�2014011771
 * ˵����ʵ��4.2
 * */

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;



import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;

public class Crawler extends BreadthCrawler {
	final static String USERNAME = "root";
	final static String PASSWORD = "111111";
	final static long PORT = 3306;
	static Connection CON = null;

	public Crawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub

	}

	public static int j = 0;

	@Override

	public void visit(Page page, CrawlDatums arg1) {
		String url = null;
		String title = null;
		String path = null;
		String time = null;
		String comment = null;
		String contents = "";
		// ��ȡ��ַ
		url = page.getUrl();
		// ��ȡ����
		title = page.getDoc().title();
		// ��ȡʱ��
		int index = url.lastIndexOf("/");
		char[] ch = url.toCharArray();// ת��Ϊ�ַ�����
		String last = null;
		// ����ҳ�����⴦��
		if (index + 1 == ch.length) {
			last = "index.html";
			time = page.getDoc().select("div[class=b_time]").text();
			contents = "��ҳ";
		} else {
			last = url.substring(index + 1, url.length());
			time = page.getDoc().select("span[class=time-source]").text();
			contents = page.getDoc().select("p").text();
			contents = contents.substring(0, 100);// �������ݺܳ����������ȡһ����д���website��
		}
		path = "downloads/" + last;
		String sql = "insert into website values(";
		sql = sql + "'" + url + "'," + "'" + title + "'," + "'" + comment + "'," + "'" + time + "'," + "'" + contents
				+ "'," + "'" + path + "')";

		// ִ�в������
		try {
			//
			PreparedStatement pstm = CON.prepareStatement(sql);
			pstm.executeUpdate(sql);

			pstm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ������ҳ
		try {
			FileUtils.writeFileWithParent("downloads/" + last, page.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j++;
		CatchThread.getMyFrame().getTitleShow().append("����ץȡ��д�����ݿ��" + (j) + "����ҳ�������Ϣ������������\n");
		CatchThread.getMyFrame().getTitleShow().append("��ַ��" + url + "\n");
		CatchThread.getMyFrame().getTitleShow().append("���⣺" + title + "\n");
		CatchThread.getMyFrame().getTitleShow().append("���ݣ�" + contents + "\n");
		CatchThread.getMyFrame().getTitleShow().append("���ۣ�" + comment + "\n");
		CatchThread.getMyFrame().getTitleShow().append("�������·����" + path + "\n");
	}

	public static void main(String[] args) {

		MyLittleFrame mlf = new MyLittleFrame();

	}
}
