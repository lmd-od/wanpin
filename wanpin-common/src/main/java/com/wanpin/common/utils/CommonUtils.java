package com.wanpin.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 通用工具类
 * </p>
 * 
 * @author litr 2016年5月26日
 * @version 1.0
 */
public class CommonUtils {
	/**
	 * <p>获取request请求IP</p>
	 * @author litr 2016年5月26日
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		// 如果是多级代理，那么取第一个ip为客户ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		return ip;
	}
	
	/**
	 * <p>是否是手机号</p>
	 * @author litr 2016年5月26日
	 * @param mobile
	 * @return
	 */
	public static boolean isMobileNO(String mobile) {
		Pattern p = Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
}
