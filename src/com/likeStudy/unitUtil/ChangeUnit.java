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
	 * 	��ȡ�ļ���·��
	 * @param bodyPx
	 * 	���ڶ���px��ת��Ϊrem
	 * @throws Exception
	 * 	io�쳣,�׳�
	 */
	public void readFile(String path, float unit, UnitArithmetic uh) throws Exception  {
		//����·����ȡ��ȡ��Ҫ�Ķ���
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
		//������ӡ�����ļ���Ҫ�Ķ���
		File newFile = new File(file.getParent()+"\\newCss.css");
		newFile.createNewFile();//�����ļ�
		FileWriter fw = new FileWriter(newFile);
		PrintWriter pw = new PrintWriter(fw);
		
		//��ȡ���޸�
		String line;
		while((line = br.readLine()) != null) {//��ȡ�ļ�һ�е����ݣ����ж��䲻Ϊnull
			String changeStr = uh.arithmetic(line,unit);//����ȡ����Str�� px ת���� rem
			//System.out.println(changeStr);
			pw.println(changeStr);//��strд���ļ�
			//pw.flush();//ǿ�ƽ�����д��Ӳ��
		}
		//�رջ���
		br.close();
		pw.close();
		System.out.println("���");
	}
	public static void main(String[] args) throws Exception {
		/*
		 * UnitArithmetic pr = new Px2Rem(); UnitArithmetic rp = new Rem2Px();
		 * 
		 * ChangeUnit cu = new ChangeUnit();
		 * //cu.readFile("D:/myProject/TestFIle/mine.css",20, pr);//���ó��򣬴����ļ�·���ͻ��ڶ���pxת��
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
		 cu.readFile("D:/myProject/TestFIle/demo.css",20, pr);//���ó��򣬴����ļ�·���ͻ��ڶ���pxת��
	}
}
