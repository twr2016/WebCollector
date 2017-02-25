package com.test2;

/*
 * ������������
 * �༶��2014��5��
 * ѧ�ţ�2014011771
 * ˵����ʵ��4.2
 * */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;

public class Crawler extends BreadthCrawler {
	// ����һ��EXCEL
	static Workbook wb = new HSSFWorkbook();
	Sheet sheet1 = null;

	public Crawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub
		// ����һ��SHEET
		sheet1 = wb.createSheet("���ݽ���");
		String[] title = { "url", "����", "����", "ʱ��", "����", "�������·��" };
		int i = 0;
		// ����һ��
		Row row = sheet1.createRow((short) 0);
		// ������
		for (String s : title) {
			Cell cell = row.createCell(i);
			cell.setCellValue(s);
			i++;
		}

	}

	static int j = 0;

	@Override

	public void visit(Page page, CrawlDatums arg1) {
		String url = null;
		String title = null;
		String path = null;
		String time = null;
		String comment = null;
		String contents = "";
		// ��ȡ��ַ
		url = page.getUrl();
		// ��ȡ����
		title = page.getDoc().title();
		// ��ȡʱ��
		int index = url.lastIndexOf("/");
		char[] ch = url.toCharArray();// ת��Ϊ�ַ�����
		String last = null;
		// ����ҳ�����⴦��
		if (index + 1 == ch.length) {
			last = "index.html";
			time = page.getDoc().select("div[class=b_time]").text();
			contents = "��ҳ";
		} else {
			last = url.substring(index + 1, url.length());
			time = page.getDoc().select("span[class=time-source]").text();
			contents = page.getDoc().select("p").text();
		}
		path = "downloads/" + last;
		FileOutputStream fileOut = null;

		AtomicInteger id=new AtomicInteger(j);
		Row row = sheet1.createRow((short)id.incrementAndGet());  

		row.createCell(0).setCellValue(url);
		row.createCell(1).setCellValue(title);
		row.createCell(2).setCellValue(comment);
		row.createCell(3).setCellValue(time);
		row.createCell(4).setCellValue(contents);
		row.createCell(5).setCellValue(path);
		j++;// ����һ�п�ʼд������
		try {
			fileOut = new FileOutputStream("downloads//spider.xls");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wb.write(fileOut);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ������ҳ
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
