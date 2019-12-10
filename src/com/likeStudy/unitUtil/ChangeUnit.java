package com.likeStudy.unitUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Test;

import com.likeStudy.unitArithmetic.UnitArithmetic;
import com.likeStudy.util.FileUtil;

public class ChangeUnit {
	/**
	 * 
	 * @param path
	 * 	��ȡ�ļ���·��
	 * @param bodyPx
	 * 	���ڶ���px��ת��Ϊrem
	 * 	����Ϊ0��С��0
	 * @throws Exception
	 * 	io�쳣,�׳�
	 */
	
	/**
	 * @param path
	 * 	��ȡ�ļ�·��(���ܺ�newPath��ͬ)
	 * @param newPath
	 * 	�洢�޸ĺ����ݵ�·��(���ܺ�path��ͬ)
	 * @param unit
	 *  ���ݶ����������޸�(����С�ڵ���0)
	 * @param uh
	 *  ת���ķ���(ʲôתʲô)
	 * */
	public void readFile(String path,String newPath, float unit, UnitArithmetic ua) {
		if(path.equals(newPath) || unit <= 0) {
			System.out.println("���ݴ���");
			return;
		}
		//����·����ȡ��ȡ��Ҫ�Ķ���
		//������ӡ�����ļ���Ҫ�Ķ���
		File file = new File(path);
		File newFile = FileUtil.createFile(newPath);
		try(FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
				FileWriter fw = new FileWriter(newFile);
				PrintWriter pw = new PrintWriter(fw);
				){
			
			//��ȡ�ļ�һ�е�����,���ж��䲻Ϊnull,Ȼ������޸�
			String line;
			while((line = br.readLine()) != null) {
				
				//����ȡ����Str�� px ת���� rem
				String changeStr = ua.arithmetic(line,unit);
				//System.out.println(changeStr);
				
				//��strд���ļ�
				pw.println(changeStr);
				
				//ǿ�ƽ�����д��Ӳ��
				//pw.flush();
			}
			System.out.println("���");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test() {
		UnitArithmetic ua = new UnitArithmetic("px","rem");
		readFile("D:/myProject/TestFIle/demo.css","D:/myProject/TestFIle/demo2.css",20, ua);
	}
}
