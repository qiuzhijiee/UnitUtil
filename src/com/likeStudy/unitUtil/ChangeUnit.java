package com.likeStudy.unitUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.likeStudy.unitArithmetic.Px2Rem;
import com.likeStudy.unitArithmetic.Rem2Px;
import com.likeStudy.unitArithmetic.UnitArithmetic;

public class ChangeUnit {
	Date date = new Date();
	SimpleDateFormat sdf;
	/**
	 * 
	 * @param path
	 * 	读取文件的路径
	 * @param bodyPx
	 * 	基于多少px来转换为rem
	 * @throws Exception
	 * 	io异常,抛出
	 */
	public void readFile(String path, float unit, UnitArithmetic uh) throws Exception  {
		//根据路径获取读取需要的对象
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
		//创建打印到新文件需要的对象
		File newFile = new File(file.getParent()+"\\newCss.css");
		newFile.createNewFile();//创建文件
		FileWriter fw = new FileWriter(newFile);
		PrintWriter pw = new PrintWriter(fw);
		
		//读取并修改
		String line;
		while((line = br.readLine()) != null) {//读取文件一行的内容，并判断其不为null
			String changeStr = uh.arithmetic(line,unit);//将读取到的Str中 px 转换成 rem
			//System.out.println(changeStr);
			pw.println(changeStr);//将str写入文件
			//pw.flush();//强制将缓存写入硬盘
		}
		//关闭缓存
		br.close();
		pw.close();
		System.out.println("完成");
	}
	public static void main(String[] args) throws Exception {
		/*
		 * UnitArithmetic pr = new Px2Rem(); UnitArithmetic rp = new Rem2Px();
		 * 
		 * ChangeUnit cu = new ChangeUnit();
		 * //cu.readFile("D:/myProject/TestFIle/mine.css",20, pr);//调用程序，传入文件路径和基于多少px转换
		 * //System.out.println(ChangeUnit.
		 * checkString(".info-nav .title{font-size: 16px; color: #333333; line-height: 422px;}"
		 * ,16f));
		 * 
		 * String path =
		 * "D:\\myProject\\ZF_YX\\website\\res.youxidp.com\\ROOT\\m\\css\\dianping.css";
		 * float unit = 50; cu.readFile(path, unit, rp);
		 * 
		 * String csspath =
		 * "D:\\myProject\\ZF_YX\\website\\res.youxidp.com\\ROOT\\m\\css\\main2.css";
		 * float unit2 = 20; cu.readFile(csspath, unit2, pr);
		 */
		//new SimpleDateFormat("yyyy-MM-dd").format(new Date());//.setTime((Long)article.get("createtime")).toString()
		 UnitArithmetic pr = new Px2Rem();
		 ChangeUnit cu = new ChangeUnit();
		 cu.readFile("D:/myProject/TestFIle/demo.css",20, pr);//调用程序，传入文件路径和基于多少px转换
	}
}
