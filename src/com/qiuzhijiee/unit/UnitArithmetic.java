package com.qiuzhijiee.unit;


public abstract class UnitArithmetic {

	//正则表达式
	protected String pattern;
	protected String toUnit;
	
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
	public abstract String modifyUnit(String line, float unit);
}
