package com.qiuzhijiee.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.qiuzhijiee.unit.BaseUnitArithmetic;
import com.qiuzhijiee.util.FileUtil;

/**
 * @author qiuzhijie
 * */
public class ChangeUnit {

	/**
	 * @param path
	 * 	读取文件路径(不能和newPath相同)
	 * @param newPath
	 * 	存储修改后数据的路径(不能和path相同)
	 * @param unit
	   *     根据多少来进行修改(不能小于等于0)    
	 * @param ua
	 *	字符串单位转换类
	 * */
	public boolean readFile(String path,String newPath, float unit, BaseUnitArithmetic ua) {
		if (path.equals(newPath) || unit <= 0) {
			System.out.println("数据错误");
			return false;
		}
		
		File file = new File(path);
		File newFile = FileUtil.createFile(newPath);
		
		try(FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
				FileWriter fw = new FileWriter(newFile);
				PrintWriter pw = new PrintWriter(fw);
				){
			
			String line;
			while((line = br.readLine()) != null) {
				String changeStr = ua.modifyUnit(line,unit);
				
				pw.println(changeStr);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
