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
		crawler.setTopN(50);// �������ץȡ����ҳ����
		CatchThread.myFrame.getTitleShow().append("������ȡ������Ϊ��http://news.sina.com.cn/\n");
		CatchThread.myFrame.getTitleShow().append("������ȡ����ҳ���ص����·��downloadsĿ¼�¡�\n");
		CatchThread.myFrame.getTitleShow().append("������ȡ������ҳ�����Ϣ���ص����·��downloads/spider.xls�¡�\n");
		CatchThread.myFrame.getTitleShow().append(
				"-----------------------------------------------���ǻ������ķָ���----------------------------------------------------\n");
		try {
			crawler.start(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CatchThread.myFrame.getTitleShow().append("-----------------------------------------------ץȡ���������ι�ץȡ"
				+ Crawler.j + "����ҳ��----------------------------------------------------\n");
	}

}
