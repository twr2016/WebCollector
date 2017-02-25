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

		crawler.setTopN(50);// ����ץȡ��ҳ�������
		CatchThread.getMyFrame().getTitleShow()
				.append("-----------------------ץȡ��ҳ���������Ϣд�뵽webcollector���ݿ��е�website����-------------------------\n");
		CatchThread.getMyFrame().getTitleShow().append("˵��������String�洢���ݴ�С���ޣ�varchar�洢���ݴ�СҲ���ޣ����Խ�ȡ�����ݵ�һ���ֽ���չʾ��д�����ݿ⣡\n");

		try {
			crawler.start(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CatchThread.getMyFrame().getTitleShow()
				.append("------------------ץȡ����������ץȡ��ץȡ��д�����ݿ�" + Crawler.j + "����ҳ--------------------\n");
		CatchThread.getMyFrame().getTitleShow().append(
				"--------------------------------------------�ǵ�Ҫ�ر����ݿ�����Ŷ��------------------------------------------------\n");
	}

}
