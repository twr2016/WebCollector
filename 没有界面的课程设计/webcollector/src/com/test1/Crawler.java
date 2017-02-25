package com.test1;

/*
 * 姓名：汤文茹
 * 班级：2014级5班
 * 学号：2014011771
 * 说明：实验4.1
 * */
import java.io.IOException;

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
	public void visit(Page page, CrawlDatums next) {
		// TODO Auto-generated method stub
		// 解析
		System.out.println("正在提取:" + page.getUrl());
		String title = page.getDoc().title();
		System.out.println("标题:" + title);

		try {
			FileUtils.writeFileWithParent("downloads/" + title + ".html", page.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Crawler crawler = new Crawler("html_crawler", true);
		crawler.addSeed("http://software.hebtu.edu.cn");
		crawler.addRegex("http://software.hebtu.edu.cn/.*");
		crawler.addRegex("-.*\\.(jpg|png|gif).*");// 通过正则表达式过滤掉图片
		crawler.setThreads(1);// 设置开启的线程数
		crawler.setTopN(1000);// 设置爬取url的上限
		try {
			crawler.start(2);//设置爬取的深度
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 爬取层数
	}

}
