package com.wanpin.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 随机号生成工具
 * @author MingDing.Li
 */
public class RanNumGainUtils {
	private static SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	 * 生成唯一订单号  startStr+时间+随机字母
	 * @author MingDing.Li
	 * @param startStr
	 * @return
	 */
	public static String orderNumGain(String startStr){
		Date now = new Date();
		return startStr+form.format(now);
	}
	
	/**
	 * 生成唯一订单号  startStr+时间+随机字母
	 * @author MingDing.Li
	 * @param startStr
	 * @return
	 */
	public static String random(String startStr){
		Date now = new Date();
		return startStr+form.format(now)+UUID.randomUUID().toString().substring(0, 3);
	}
	
	/**
	 * <p>动态生成随机<code>charCount</code>位数字</p>
	 * @author litr 2016年6月20日
	 * @param charCount
	 * @return
	 */
	public static String getRandomNum(int charCount) {
		StringBuffer charValue = new StringBuffer();
		for (int i = 0; i < charCount; i++) {
			char c = (char) (randomInt(0, 10) + '0');
			charValue.append(c);
		}
		return charValue.toString();
	}

	public static int randomInt(int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to - from);
	}
	
	
}
