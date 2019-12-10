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
	 * 	读取文件的路径
	 * @param bodyPx
	 * 	基于多少px来转换为rem
	 * 	不能为0或小于0
	 * @throws Exception
	 * 	io异常,抛出
	 */
	
	/**
	 * @param path
	 * 	读取文件路径(不能和newPath相同)
	 * @param newPath
	 * 	存储修改后数据的路径(不能喝path相同)
	 * @param unit
	 *  根据多少来进行修改(不能小于等于0)
	 * @param uh
	 *  转换的方法(什么转什么)
	 * */
	public void readFile(String path,String newPath, float unit, UnitArithmetic ua) {
		if(path.equals(newPath) || unit <= 0) {
			System.out.println("数据错误");
			return;
		}
		//根据路径获取读取需要的对象
		//创建打印到新文件需要的对象
		File file = new File(path);
		File newFile = FileUtil.createFile(newPath);
		try(FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
				FileWriter fw = new FileWriter(newFile);
				PrintWriter pw = new PrintWriter(fw);
				){
			
			//读取文件一行的内容,并判断其不为null,然后进行修改
			String line;
			while((line = br.readLine()) != null) {
				
				//将读取到的Str中 px 转换成 rem
				String changeStr = ua.arithmetic(line,unit);
				//System.out.println(changeStr);
				
				//将str写入文件
				pw.println(changeStr);
				
				//强制将缓存写入硬盘
				//pw.flush();
			}
			System.out.println("完成");
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
