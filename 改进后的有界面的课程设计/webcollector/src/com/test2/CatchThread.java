package com.test2;

public class CatchThread implements Runnable {
	public static MyFrame myFrame;

	public static MyFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	public CatchThread(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		Crawler crawler = new Crawler("html_crawler", true);
		crawler.addSeed("http://news.sina.com.cn/");
		crawler.addRegex("http://news.sina.com.cn/.*");
		crawler.setTopN(50);// 设置最多抓取的网页个数
		CatchThread.myFrame.getTitleShow().append("设置爬取的种子为：http://news.sina.com.cn/\n");
		CatchThread.myFrame.getTitleShow().append("设置爬取的网页下载到相对路径downloads目录下。\n");
		CatchThread.myFrame.getTitleShow().append("设置爬取到的网页相关信息下载到相对路径downloads/spider.xls下。\n");
		CatchThread.myFrame.getTitleShow().append(
				"-----------------------------------------------我是华丽丽的分割线----------------------------------------------------\n");
		try {
			crawler.start(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CatchThread.myFrame.getTitleShow().append("-----------------------------------------------抓取结束，本次共抓取"
				+ Crawler.j + "个网页。----------------------------------------------------\n");
	}

}
