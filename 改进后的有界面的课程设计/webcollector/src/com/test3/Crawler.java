package com.test3;

/*
 * 姓名：汤文茹
 * 班级：2014级5班
 * 学号：2014011771
 * 说明：实验4.2
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
		// 获取网址
		url = page.getUrl();
		// 获取标题
		title = page.getDoc().title();
		// 获取时间
		int index = url.lastIndexOf("/");
		char[] ch = url.toCharArray();// 转换为字符数组
		String last = null;
		// 对首页做特殊处理
		if (index + 1 == ch.length) {
			last = "index.html";
			time = page.getDoc().select("div[class=b_time]").text();
			contents = "首页";
		} else {
			last = url.substring(index + 1, url.length());
			time = page.getDoc().select("span[class=time-source]").text();
			contents = page.getDoc().select("p").text();
			contents = contents.substring(0, 100);// 由于内容很长，在这里截取一部分写入表website中
		}
		path = "downloads/" + last;
		String sql = "insert into website values(";
		sql = sql + "'" + url + "'," + "'" + title + "'," + "'" + comment + "'," + "'" + time + "'," + "'" + contents
				+ "'," + "'" + path + "')";

		// 执行插入语句
		try {
			//
			PreparedStatement pstm = CON.prepareStatement(sql);
			pstm.executeUpdate(sql);

			pstm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 下载网页
		try {
			FileUtils.writeFileWithParent("downloads/" + last, page.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j++;
		CatchThread.getMyFrame().getTitleShow().append("正在抓取并写入数据库第" + (j) + "个网页的相关信息······\n");
		CatchThread.getMyFrame().getTitleShow().append("网址：" + url + "\n");
		CatchThread.getMyFrame().getTitleShow().append("标题：" + title + "\n");
		CatchThread.getMyFrame().getTitleShow().append("内容：" + contents + "\n");
		CatchThread.getMyFrame().getTitleShow().append("评论：" + comment + "\n");
		CatchThread.getMyFrame().getTitleShow().append("本地相对路径：" + path + "\n");
	}

	public static void main(String[] args) {

		MyLittleFrame mlf = new MyLittleFrame();

	}
}
