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
		CatchThread.getMyFrame().getTitleShow().append("正在提取:" + page.getUrl() + "\n");
		String title = page.getDoc().title();
		CatchThread.getMyFrame().getTitleShow().append("标题:" + title + "\n");

		try {
			FileUtils.writeFileWithParent("downloads/" + title + ".html", page.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}

}
