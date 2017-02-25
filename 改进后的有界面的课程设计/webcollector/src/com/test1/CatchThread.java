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
		CatchThread.myFrame.getTitleShow().append("ץȡ������Ϊ:" + "http://software.hebtu.edu.cn" + "\n");
		crawler.addRegex("http://software.hebtu.edu.cn/.*");
		crawler.addRegex("-.*\\.(jpg|png|gif).*");// ͨ��������ʽ���˵�ͼƬ
		crawler.setThreads(1);// ���ÿ������߳���
		CatchThread.myFrame.getTitleShow().append("������ȡ�����Ϊ��2\n");
		CatchThread.myFrame.getTitleShow().append("���ÿ������߳���Ϊ��1\n");
		crawler.setTopN(1000);// ������ȡurl������
		CatchThread.myFrame.getTitleShow().append("������ȡ��url����Ϊ��1000\n");
		CatchThread.myFrame.getTitleShow().append("����������ʽΪ��-.*\\.(jpg|png|gif).*" + "\n");
		CatchThread.myFrame.getTitleShow().append(
				"-----------------------------------------------���ǻ������ķָ���----------------------------------------------------\n");
		try {
			crawler.start(2);// ������ȡ�����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ��ȡ����
	}

}
