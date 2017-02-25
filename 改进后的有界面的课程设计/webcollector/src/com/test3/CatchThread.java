package com.test3;

public class CatchThread implements Runnable {
	public static MyFrame myFrame;

	public static MyFrame getMyFrame() {
		return myFrame;
	}

	public static void setMyFrame(MyFrame myFrame) {
		CatchThread.myFrame = myFrame;
	}

	public CatchThread(MyFrame myFrame) {
		CatchThread.myFrame = myFrame;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Crawler crawler = new Crawler("html_crawler", true);
		crawler.addSeed("http://news.sina.com.cn/");
		crawler.addRegex("http://news.sina.com.cn/.*");

		crawler.setTopN(50);// 设置抓取网页的最大数
		CatchThread.getMyFrame().getTitleShow()
				.append("-----------------------抓取网页并将相关信息写入到webcollector数据库中的website表中-------------------------\n");
		CatchThread.getMyFrame().getTitleShow().append("说明：由于String存储数据大小有限，varchar存储数据大小也有限，所以截取了内容的一部分进行展示并写入数据库！\n");

		try {
			crawler.start(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CatchThread.getMyFrame().getTitleShow()
				.append("------------------抓取结束，本次抓取共抓取并写入数据库" + Crawler.j + "个网页--------------------\n");
		CatchThread.getMyFrame().getTitleShow().append(
				"--------------------------------------------记得要关闭数据库连接哦！------------------------------------------------\n");
	}

}
