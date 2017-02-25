package com.test1;

public class CatchThread implements Runnable {
	public static MyFrame myFrame;

	public static MyFrame getMyFrame() {
		return myFrame;
	}

	public void setMyFrame(MyFrame myFrame) {
		CatchThread.myFrame = myFrame;
	}

	public CatchThread(MyFrame myFrame) {
		CatchThread.myFrame = myFrame;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		Crawler crawler = new Crawler("html_crawler", true);
		crawler.addSeed("http://software.hebtu.edu.cn");
		CatchThread.myFrame.getTitleShow().append("抓取的种子为:" + "http://software.hebtu.edu.cn" + "\n");
		crawler.addRegex("http://software.hebtu.edu.cn/.*");
		crawler.addRegex("-.*\\.(jpg|png|gif).*");// 通过正则表达式过滤掉图片
		crawler.setThreads(1);// 设置开启的线程数
		CatchThread.myFrame.getTitleShow().append("设置爬取的深度为：2\n");
		CatchThread.myFrame.getTitleShow().append("设置开启的线程数为：1\n");
		crawler.setTopN(1000);// 设置爬取url的上限
		CatchThread.myFrame.getTitleShow().append("设置爬取的url上限为：1000\n");
		CatchThread.myFrame.getTitleShow().append("设置正则表达式为：-.*\\.(jpg|png|gif).*" + "\n");
		CatchThread.myFrame.getTitleShow().append(
				"-----------------------------------------------我是华丽丽的分割线----------------------------------------------------\n");
		try {
			crawler.start(2);// 设置爬取的深度
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 爬取层数
	}

}
