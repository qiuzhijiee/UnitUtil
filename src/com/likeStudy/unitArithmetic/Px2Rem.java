package com.likeStudy.unitArithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Px2Rem extends UnitArithmetic {
	
	public String arithmetic(String line,float unit) {
		//正则表达式
		String pattern = "([0-9.]*+px)";
		
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		
		while(m.find()) {
			String result = m.group(1);
			float f = Float.parseFloat(result.substring(0, result.length()-2)) / unit;
			line = m.replaceFirst(f+"rem");
			
			//需要重新给Matcher赋值，上面使用的是replaceFirst，不重新赋值如果有多个就会一直更改第一个(死循环)
			//可能有更好的替换方法，目前只知道replaceFirst 和 replaceAll  替换第一个和替换全部
			m = r.matcher(line);
		}
		return line;
	}
}
