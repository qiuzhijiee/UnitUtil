package com.unit.tool;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileUtil {
	public static File createFile(String path) {
		File file = new File(path);
		if(file.isDirectory()) {
			System.out.println("传入路径为文件夹");
			return null;
			//throw new Exception("传入路径为文件夹");
		}
		if(!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	
	@Test
	public void test1() throws Exception {
		try {
		File file = createFile("D:\\myProject\\TestFIle\\demo");
		System.out.println(file.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
