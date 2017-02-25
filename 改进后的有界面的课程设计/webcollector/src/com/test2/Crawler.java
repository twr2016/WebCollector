package com.test2;

/*
 * 姓名：汤文茹
 * 班级：2014级5班
 * 学号：2014011771
 * 说明：实验4.2
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
	// 创建一个EXCEL
	static Workbook wb = new HSSFWorkbook();
	Sheet sheet1 = null;

	public Crawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub
		// 创建一个SHEET
		sheet1 = wb.createSheet("数据解析");
		String[] title = { "url", "标题", "评论", "时间", "内容", "本地相对路径" };
		int i = 0;
		// 创建一行
		Row row = sheet1.createRow((short) 0);
		// 填充标题
		for (String s : title) {
			Cell cell = row.createCell(i);
			cell.setCellValue(s);
			i++;
		}

	}

	public static int j = 0;

	@Override

	public void visit(Page page, CrawlDatums arg1) {
		String url = null;
		String title = null;
		String path = null;
		String time = null;
		String comment = null;
		String contents = "";
		// 获取网址
		url = page.getUrl();
		// 获取标题
		title = page.getDoc().title();
		// 获取时间
		int index = url.lastIndexOf("/");
		char[] ch = url.toCharArray();// 转换为字符数组
		String last = null;
		// 对首页做特殊处理
		if (index + 1 == ch.length) {
			last = "index.html";
			time = page.getDoc().select("div[class=b_time]").text();
			contents = "首页";
		} else {
			last = url.substring(index + 1, url.length());
			time = page.getDoc().select("span[class=time-source]").text();
			contents = page.getDoc().select("p").text();
		}
		if (last.contains("?")) {
			last = last.replace("?", "-");
		}
		path = "downloads/" + last;
		FileOutputStream fileOut = null;

		AtomicInteger id = new AtomicInteger(j);
		Row row = sheet1.createRow((short) id.incrementAndGet());

		row.createCell(0).setCellValue(url);
		row.createCell(1).setCellValue(title);
		row.createCell(2).setCellValue(comment);
		row.createCell(3).setCellValue(time);
		if (contents.length() > 1000) {
			contents = contents.substring(0, 1000);
		} // 截取contents,太长excel表单元格放不下，String数据类型装不下
		row.createCell(4).setCellValue(contents);
		row.createCell(5).setCellValue(path);
		CatchThread.getMyFrame().getTitleShow().append("第" + (j + 1) + "个网页相关信息如下：\n");
		// 将获取到的网址相关信息展示到textarea中
		CatchThread.getMyFrame().getTitleShow().append("网址:" + url + "\n");
		CatchThread.getMyFrame().getTitleShow().append("标题:" + title + "\n");
		CatchThread.getMyFrame().getTitleShow().append("评论:" + comment + "\n");
		CatchThread.getMyFrame().getTitleShow().append("时间:" + time + "\n");
		CatchThread.getMyFrame().getTitleShow().append("内容:" + contents + "\n");

		CatchThread.getMyFrame().getTitleShow().append("本地相对路径:" + path + "\n");
		j++;// 从下一行开始写入内容
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
		// 下载网页
		try {
			FileUtils.writeFileWithParent("downloads/" + last, page.getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		MyFrame myframe = new MyFrame();

	}
}
