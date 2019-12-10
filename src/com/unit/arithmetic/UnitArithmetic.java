package com.unit.arithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitArithmetic {

	//������ʽ
	private String pattern;
	private String toUnit;
	
	public UnitArithmetic(String originUnit, String toUnit) {
		pattern = "([0-9.]*+"+originUnit+")";
		this.toUnit = toUnit.trim();
	}
	
	
	
	/**
	 * 
	 * @param line
	 * 	��Ҫת����String
	 * @param unit
	 * 	���ڶ��ٵ�λ��ת��Ϊ�µĵ�λ
	 * @return
	 * 	��ת���õ�String����
	 */
	public String arithmetic(String line, float unit) {
		if(pattern == null || "".equals(pattern) || toUnit == null || "".equals(toUnit)) {
			System.out.println("�����쳣");
			return null;
		}
		
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		
		while(m.find()) {
			String result = m.group(1);
			float f = Float.parseFloat(result.substring(0, result.length()-toUnit.length())) * unit;
			line = m.replaceFirst(f+toUnit);
			
			//��Ҫ���¸�Matcher��ֵ������ʹ�õ���replaceFirst�������¸�ֵ����ж���ͻ�һֱ���ĵ�һ��(��ѭ��)
			//�����и��õ��滻������Ŀǰֻ֪��replaceFirst �� replaceAll  �滻��һ�����滻ȫ��
			m = r.matcher(line);
		}
		return line;
	}
}
