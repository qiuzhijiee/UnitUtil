package com.likeStudy.unitArithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Px2Rem extends UnitArithmetic {
	
	public String arithmetic(String line,float unit) {
		//������ʽ
		String pattern = "([0-9.]*+px)";
		
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		
		while(m.find()) {
			String result = m.group(1);
			float f = Float.parseFloat(result.substring(0, result.length()-2)) / unit;
			line = m.replaceFirst(f+"rem");
			
			//��Ҫ���¸�Matcher��ֵ������ʹ�õ���replaceFirst�������¸�ֵ����ж���ͻ�һֱ���ĵ�һ��(��ѭ��)
			//�����и��õ��滻������Ŀǰֻ֪��replaceFirst �� replaceAll  �滻��һ�����滻ȫ��
			m = r.matcher(line);
		}
		return line;
	}
}
