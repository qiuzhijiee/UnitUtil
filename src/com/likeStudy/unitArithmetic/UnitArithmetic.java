package com.likeStudy.unitArithmetic;

public abstract class UnitArithmetic {
	/**
	 * 
	 * @param line
	 * 	需要转换的String
	 * @param bodyPx
	 * 	基于多少px来转换为rem
	 * @return
	 * 	将转换好的String返回
	 */
	abstract public String arithmetic(String line, float unit);
}
