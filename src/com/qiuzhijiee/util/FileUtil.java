package com.qiuzhijiee.util;

import java.io.File;
import java.io.IOException;


/**
 * @author qiuzhijie
 * */
public class FileUtil {
	public static File checkFile(String path) {
		File file = new File(path);
		if (file.isFile()) {
			return file;
		}else {
			return null;	
		}
	}
	
	public static File createFile(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			System.out.println("传入路径为文件夹");
			return null;
			//throw new Exception("传入路径为文件夹");
		}
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
}
