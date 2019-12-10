package com.unit.arithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitArithmetic {

	//正则表达式
	private String pattern;
	private String toUnit;
	
	public UnitArithmetic(String originUnit, String toUnit) {
		pattern = "([0-9.]*+"+originUnit+")";
		this.toUnit = toUnit.trim();
	}
	
	
	
	/**
	 * 
	 * @param line
	 * 	需要转换的String
	 * @param unit
	 * 	基于多少单位来转换为新的单位
	 * @return
	 * 	将转换好的String返回
	 */
	public String arithmetic(String line, float unit) {
		if(pattern == null || "".equals(pattern) || toUnit == null || "".equals(toUnit)) {
			System.out.println("属性异常");
			return null;
		}
		
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		
		while(m.find()) {
			String result = m.group(1);
			float f = Float.parseFloat(result.substring(0, result.length()-toUnit.length())) * unit;
			line = m.replaceFirst(f+toUnit);
			
			//需要重新给Matcher赋值，上面使用的是replaceFirst，不重新赋值如果有多个就会一直更改第一个(死循环)
			//可能有更好的替换方法，目前只知道replaceFirst 和 replaceAll  替换第一个和替换全部
			m = r.matcher(line);
		}
		return line;
	}
}
