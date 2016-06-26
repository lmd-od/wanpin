package com.wanpin.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

public class SmsUtils {

	public static final String SEND_TIME = "sendTime";
	
	public static void setMobileCode(String mobile, String vcode, HttpServletRequest request) {
		request.getSession().setAttribute(mobile, vcode);
		request.getSession().setAttribute(mobile + SEND_TIME, System.currentTimeMillis());
	}
	
	public static String getSmsValidCode(String mobile, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		if(StringUtils.isEmpty(mobile)) return null;
		if(session == null) return null;
		
		Object validCode = session.getAttribute(mobile);
		
		if(validCode == null) return null;
		
		return (String) validCode;
	}
	
	public static Long getSmsSendTime(String mobile, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		if(session == null) return null;
		
		Object sendTime = session.getAttribute(mobile + SEND_TIME);
		if(sendTime == null) return null;
		
		return (Long) sendTime;
	}
	
	public static boolean validMobileCodeIsValid(String mobile,String validCode,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String sessionCode = getSmsValidCode(mobile, request);
		Long beforeTime = getSmsSendTime(mobile, request);
		Long currentTime = System.currentTimeMillis();
		if(StringUtils.isEmpty(validCode) || StringUtils.isEmpty(sessionCode) || beforeTime == null) return false;
		
		if(!sessionCode.equalsIgnoreCase(validCode)) return false;
		
		if((currentTime-beforeTime)/1000-300>0) return false;
		
		session.removeAttribute(mobile);
		session.removeAttribute(mobile + SEND_TIME);
		
		return true;
	}
	
}
