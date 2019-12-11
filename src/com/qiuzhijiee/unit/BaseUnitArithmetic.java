package com.qiuzhijiee.unit;


/**
 * @author qiuzhijie
 * */
public abstract class BaseUnitArithmetic {
	
	protected String pattern;
	protected String toUnit;
	
	public BaseUnitArithmetic(String originUnit, String toUnit) {
		pattern = "([0-9.]*+"+originUnit+")";
		this.toUnit = toUnit.trim();
	}
	
	
	
	/**
	 * 用来根据unit修改字符串的单位  例：padding: 16px; ->  padding: 1rem;
	 * 
	 * @param line
	 * 	需要转换的String
	 * @param unit
	 * 	基于多少单位来转换为新的单位
	 * @return
	 * 	将转换好的String返回
	 */
	public abstract String modifyUnit(String line, float unit);
}
