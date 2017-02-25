package com.test3;

/*
 * 姓名：汤文茹
 * 班级：2014级5班
 * 学号：2014011771
 * 说明：实验4.2
 * */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;

public class Crawler extends BreadthCrawler {

	public Crawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub

	}

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
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败！");
			e.printStackTrace();
		}

		String url1 = "jdbc:mysql://127.0.0.1:" + 3306 + "/webcollector?useUnicode=true&characterEncoding=UTF-8";
		try {
			// 建立数据库连接
			connection = DriverManager.getConnection(url1, "root", "111111");

			// System.out.println("数据库连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		// 执行插入语句
		try {
			//
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.executeUpdate(sql);
			pstm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 下载网页
		try {
			FileUtils.writeFileWithParent("downloads/" + last, page.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Crawler crawler = new Crawler("html_crawler", true);
		crawler.addSeed("http://news.sina.com.cn/");
		crawler.addRegex("http://news.sina.com.cn/.*");

		try {
			crawler.start(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
