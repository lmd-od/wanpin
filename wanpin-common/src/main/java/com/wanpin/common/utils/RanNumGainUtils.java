package com.wanpin.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	
}
