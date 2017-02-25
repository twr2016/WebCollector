package com.test1;

/*
 * ������������
 * �༶��2014��5��
 * ѧ�ţ�2014011771
 * ˵����ʵ��4.1
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
		// ����
		System.out.println("������ȡ:" + page.getUrl());
		String title = page.getDoc().title();
		System.out.println("����:" + title);

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
		crawler.addRegex("-.*\\.(jpg|png|gif).*");// ͨ��������ʽ���˵�ͼƬ
		crawler.setThreads(1);// ���ÿ������߳���
		crawler.setTopN(1000);// ������ȡurl������
		try {
			crawler.start(2);//������ȡ�����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ��ȡ����
	}

}
